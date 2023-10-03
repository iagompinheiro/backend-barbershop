package com.iagompinheiro.backend.BarberShop.controller;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.exceptions.UserException;
import com.iagompinheiro.backend.BarberShop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) throws UserException {
        User newUser = userService.create(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws UserException {
        List<User> allUsers = userService.getAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws UserException {
        User userById = userService.findById(id);
        return ResponseEntity.ok().body(userById);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws UserException {
        User newUser = userService.updateUsers(id, userDto);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) throws UserException {
        userService.delete(id);

    }

}
