package com.spring.connect.controller;

import com.spring.connect.Repository.UserRepository;
import com.spring.connect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return "user added successfully";
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
