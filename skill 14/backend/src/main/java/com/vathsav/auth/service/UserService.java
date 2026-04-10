package com.vathsav.auth.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.vathsav.auth.model.User;

@Service
public class UserService{
private List<User> users=new ArrayList<>();

public void register(User u){users.add(u);}

public User login(String username,String password){
for(User u:users){
if(u.username.equals(username)&&u.password.equals(password)){
return u;
}}
return null;
}

public User get(String username){
return users.stream().filter(u->u.username.equals(username)).findFirst().orElse(null);
}
}