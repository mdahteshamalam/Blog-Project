package com.blogapp111.controller;

import com.blogapp111.dto.Signup;
import com.blogapp111.entity.User;

import com.blogapp111.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> createUser(@RequestBody Signup signUp){
        if(userRepository.existByEmail(signUp.getEmail())){
            return new ResponseEntity<>("email id is already register", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existByUserName(signUp.getUsername())){
            return new ResponseEntity<>("userName id is already register", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        User user=new User();
        user.setName(signUp.getName());
        user.setUsername(signUp.getUsername());
        user.setPassword(signUp.getPassword());
        user.setEmail(signUp.getEmail());

        userRepository.save(user);
        return new ResponseEntity<>("user registered",HttpStatus.CREATED);
    }
}
