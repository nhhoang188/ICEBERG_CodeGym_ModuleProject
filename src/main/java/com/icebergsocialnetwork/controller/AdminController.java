package com.icebergsocialnetwork.controller;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.ImplServices.UserService;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/users")
    public Iterable<User> getAllUser(){
        return iUserService.findAll();
    }
}

