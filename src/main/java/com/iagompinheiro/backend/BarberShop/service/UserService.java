package com.iagompinheiro.backend.BarberShop.service;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    public List<User> listAll() {
       return userRepository.findAll();
    }

    public User findById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteById(@PathVariable Long id) {
         userRepository.deleteById(id);
    }


}
