package com.iagompinheiro.backend.BarberShop.service;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User create(UserDto userDto) {
        User newUser = new User(userDto);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUsers(Long id, UserDto userDto) {
        User updateUser = findById(id);
        updateUser.setFirstName(userDto.firstName());
        updateUser.setLastName(userDto.lastName());
        updateUser.setEmail(userDto.email());
        return userRepository.save(updateUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
