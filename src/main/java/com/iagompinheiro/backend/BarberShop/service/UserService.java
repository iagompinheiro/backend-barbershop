package com.iagompinheiro.backend.BarberShop.service;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User createUser(UserDto userDto) {
        User newUser = new User(userDto);
        this.saveUser(newUser);
        return newUser;
    }
}
