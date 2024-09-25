package com.a3_estudo.web.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.a3_estudo.web.entities.*;
import com.a3_estudo.web.repositories.UserRepository;



@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository user_repo;

    @GetMapping
    public List<User> findAll() {
        List<User> result = user_repo.findAll();
        return result;
    }
}
