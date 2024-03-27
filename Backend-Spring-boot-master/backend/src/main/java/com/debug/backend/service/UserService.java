package com.debug.backend.service;

import com.debug.backend.controller.DuplicateEmailException;
import com.debug.backend.entity.Product;
import com.debug.backend.entity.User;
import com.debug.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        // Check if the email is already in use
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("Email is already in use");
        }

        // Your logic to save the user
        return userRepository.save(user);
    }

    public User findUsername(String userName) {
        return userRepository.findUsername(userName);
    }

    public int getCountOfUsersWithRoleZero() {
        return userRepository.countByRole(String.valueOf(0));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
