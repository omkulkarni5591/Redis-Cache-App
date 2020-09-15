package com.oksoft.resource;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oksoft.model.User;
import com.oksoft.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

     private UserRepository userRepository;
     
     public UserResource(UserRepository userRepository) {
    	 this.userRepository=userRepository;
     }
     
     @PostMapping(value="/add",consumes="application/json")
     public User add(@RequestBody User user) {
    	 userRepository.save(user);
    	 return userRepository.findById(user.getUserId());
     } 	
     
     @GetMapping(value="/allUser")
     public Map<String,User> getAllUser(){
    	 Map<String, User> allUsers = userRepository.findAll();
    	 return allUsers;
     }
}
