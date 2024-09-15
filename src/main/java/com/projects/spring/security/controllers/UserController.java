package com.projects.spring.security.controllers;


import com.projects.spring.security.model.Users;
import com.projects.spring.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    final
    RegisterService service;

    public UserController(RegisterService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
}
