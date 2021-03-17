package com.icebergsocialnetwork.controller;

import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController()
public class RegisterApi {
    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/register")
    public ResponseEntity<String> admin(){
        return new ResponseEntity<>("admin", HttpStatus.OK);
    }
}
