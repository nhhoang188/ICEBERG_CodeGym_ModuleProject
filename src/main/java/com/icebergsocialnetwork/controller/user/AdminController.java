package com.icebergsocialnetwork.controller.user;

import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/users")
    public Iterable<User> getAllUser() {
        return iUserService.findAll();
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> blockUser(@RequestBody User user,
                                          @PathVariable Long id) {
        User user1 = iUserService.findById(id);
        user1.setUserStatus(user.getUserStatus());
        iUserService.save(user1);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PutMapping("/users/block/{user}")
    public ResponseEntity<?> lockUser(@PathVariable String user) {
        return new ResponseEntity<>(iUserService.lockUser(user), HttpStatus.OK);
    }
    @PutMapping("/users/active")
    public ResponseEntity<?> activeUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.unlockUser(user.getUsername()), HttpStatus.OK);
    }

}

