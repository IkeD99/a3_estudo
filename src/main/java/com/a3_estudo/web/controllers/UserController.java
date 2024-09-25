package com.a3_estudo.web.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3_estudo.web.entities.User;
import com.a3_estudo.web.exception.ResourceNotFoundException;
import com.a3_estudo.web.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository user_repo;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return user_repo.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = user_repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return user_repo.save(user);
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = user_repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        final User updatedUser = user_repo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = user_repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        
        user_repo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}