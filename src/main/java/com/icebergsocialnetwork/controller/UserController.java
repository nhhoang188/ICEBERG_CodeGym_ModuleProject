package com.icebergsocialnetwork.controller;


import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public Iterable<User> getAll() {
        return iUserService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id) {
        return iUserService.findById(id);
    }

    @GetMapping("/users/info/{id}")
    public User getByIdAndInforIsPublic(@PathVariable Long id) {
        return iUserService.findUserByIdAndInfomodifierIsTrue(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iUserService.save(user), HttpStatus.OK);
    }

    @GetMapping("/users/{username}/friend")
    public List<User> getFriends(@PathVariable("username")String username) {
        return iUserService.getFriends(username);
    }

    @GetMapping("/users/name/{username}")
    public User getUser(@PathVariable("username") String username) {
        return iUserService.findByUsername(username);

    }

    @GetMapping("/user/know/{id}")
    public ResponseEntity<?> userYouMayKnow(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iUserService.userYouMayKnow(id), HttpStatus.OK);
    }

    @GetMapping("/users/search")
    public List<User> findAllByFullnameContaining(@RequestParam String fullname){
        return iUserService.findAllByFullnameContaining(fullname);
    }


}
