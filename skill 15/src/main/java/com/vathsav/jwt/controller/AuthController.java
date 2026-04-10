package com.vathsav.jwt.controller;

import org.springframework.web.bind.annotation.*;
import com.vathsav.jwt.model.User;
import com.vathsav.jwt.security.JwtUtil;

@RestController
@CrossOrigin
public class AuthController {

@PostMapping("/login")
public String login(@RequestBody User user){
if(user.username.equals("admin") && user.password.equals("123")){
return JwtUtil.generateToken(user.username,"ADMIN");
}
if(user.username.equals("emp") && user.password.equals("123")){
return JwtUtil.generateToken(user.username,"EMPLOYEE");
}
return "Invalid";
}

@GetMapping("/admin/add")
public String admin(@RequestHeader("Authorization") String token){
var claims = JwtUtil.validate(token.replace("Bearer ",""));
if(!claims.get("role").equals("ADMIN")) return "Access Denied";
return "Admin Access Granted";
}

@GetMapping("/employee/profile")
public String emp(@RequestHeader("Authorization") String token){
var claims = JwtUtil.validate(token.replace("Bearer ",""));
return "Welcome "+claims.getSubject();
}
}