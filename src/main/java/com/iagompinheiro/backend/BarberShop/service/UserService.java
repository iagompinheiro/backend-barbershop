package com.iagompinheiro.backend.BarberShop.service;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import com.iagompinheiro.backend.BarberShop.exceptions.UserException;
import com.iagompinheiro.backend.BarberShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserDto userDto) throws UserException {
        try {
            User newUser = new User(userDto);
            this.userRepository.save(newUser);
            return newUser;
        } catch (Exception e) {
            throw new UserException("Erro ao criar usuários.");
        }
    }

    public List<User> getAll() throws UserException {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new UserException("erro ao listar usuários");
        }
    }


    public User findById(Long id) throws UserException {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new UserException("Usuário não encontrado");
        }
    }

    public User updateUsers(Long id, UserDto userDto) throws UserException {
        try {
            User updateUser = findById(id);
            updateUser.setFirstName(userDto.firstName());
            updateUser.setLastName(userDto.lastName());
            updateUser.setEmail(userDto.email());
            return userRepository.save(updateUser);

        } catch (Exception e) {
            throw new UserException("Não foi possível atualizar usuário");
        }
    }

    public void delete(Long id) throws UserException {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserException("Usuário não encontrado");
        }
    }

}
