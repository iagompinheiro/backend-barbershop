package com.iagompinheiro.backend.BarberShop.controller;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.exceptions.UserException;
import com.iagompinheiro.backend.BarberShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) throws UserException {
        try {
            User newUser = userService.create(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new UserException("Erro ao criar usuários.");
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws UserException {
        try {
            List<User> allUsers = userService.getAll();
            return ResponseEntity.ok(allUsers);
        } catch (Exception e) {
            throw new UserException("erro ao listar usuários");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws UserException {
        try {
            User userById = userService.findById(id);
            return ResponseEntity.ok().body(userById);
        }catch (Exception e) {
            throw new UserException("Usuário não encontrado");
        }
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody UserDto userDto) throws UserException {
           try {
               User newUser = userService.updateUsers(id, userDto);
               return ResponseEntity.ok().body(newUser);
           }catch (Exception e) {
               throw new UserException("Não foi possível atualizar usuário");
           }
        }


        @DeleteMapping(value = "/{id}")
        public void deleteById (@PathVariable Long id) throws UserException {
            try {
                userService.delete(id);
            }catch (Exception e) {
                throw new UserException("Usuário não encontrado");
            }

        }

    }
