package com.vathsav.auth.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.vathsav.auth.model.User;
import com.vathsav.auth.service.UserService;

@RestController
@CrossOrigin
public class AuthController{

@Autowired
UserService service;

@PostMapping("/register")
public String register(@RequestBody User u){
service.register(u);
return "Registered";
}

@PostMapping("/login")
public User login(@RequestBody User u){
return service.login(u.username,u.password);
}

@GetMapping("/profile/{username}")
public User profile(@PathVariable String username){
return service.get(username);
}
}