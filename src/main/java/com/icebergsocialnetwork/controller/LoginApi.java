package com.icebergsocialnetwork.controller;

import com.icebergsocialnetwork.model.user.JwtResponse;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.ImplServices.JwtService;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LoginApi {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateAccessToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return new ResponseEntity<>("admin", HttpStatus.OK);
    }
}
