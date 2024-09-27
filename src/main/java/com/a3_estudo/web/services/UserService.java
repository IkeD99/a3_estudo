package com.a3_estudo.web.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.a3_estudo.web.repositories.UserRepository;
import com.a3_estudo.web.entities.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository user_repo;

    @Autowired
    public UserService(UserRepository user_repo) {
        this.user_repo = user_repo;
    }

    public List<User> getAllUsers() {
        return user_repo.findAll();
    }

    public User findById(Long id) {
        Optional<User> userOptional = user_repo.findById(id);
        return userOptional.orElseThrow();
    }

    public User insertUser(User user) {
        return user_repo.save(user);
    }

    public User updateUser(User user) {
        return user_repo.save(user);
    }

    public void deleteUser(Long id) {
        user_repo.deleteById(id);
    }

    public User findByEmailAndPassword(String email, String password) {
        return user_repo.findByEmailAndPassword(email, password);
    }
}