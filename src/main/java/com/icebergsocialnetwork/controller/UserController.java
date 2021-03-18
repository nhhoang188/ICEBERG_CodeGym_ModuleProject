package com.icebergsocialnetwork.controller;


import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping
    public Iterable<User> getAll(){
        return iUserService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return iUserService.findById(id);
    }
}
