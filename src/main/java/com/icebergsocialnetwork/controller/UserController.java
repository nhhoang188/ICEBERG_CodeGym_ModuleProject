package com.icebergsocialnetwork.controller;


import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping
    public Iterable<User> getAll(){
        return iUserService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id){
        return iUserService.findById(id);
    }
    @GetMapping("/users/info/{id}")
    public User getByIdAndInforIsPublic(@PathVariable Long id){
        return iUserService.findUserByIdAndInfomodifierIsTrue(id);
    }
}
