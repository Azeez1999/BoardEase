package com.debug.backend.controller;

import com.debug.backend.dto.UserDTO;
import com.debug.backend.entity.Product;
import com.debug.backend.entity.User;
import com.debug.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (DuplicateEmailException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        User user = userService.findUsername(userDTO.getEmail());

        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/countByRoleZero")
    public int getCountOfUsersWithRoleZero() {
        return userService.getCountOfUsersWithRoleZero();
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }
}
