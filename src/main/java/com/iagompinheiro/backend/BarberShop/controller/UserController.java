package com.iagompinheiro.backend.BarberShop.controller;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User newUser = userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping
    public List<User> listAll(){
        return userService.listAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
