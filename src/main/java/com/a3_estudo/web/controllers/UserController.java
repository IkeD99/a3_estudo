package com.a3_estudo.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3_estudo.web.entities.User;
import com.a3_estudo.web.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public User insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        // Find the user by email and password
        User existingUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser != null) {
        return existingUser;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}