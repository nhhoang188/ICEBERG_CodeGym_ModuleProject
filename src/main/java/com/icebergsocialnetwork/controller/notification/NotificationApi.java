package com.icebergsocialnetwork.controller.notification;

import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping
public class NotificationApi {
    @Autowired
    IFriendReques friendReques;
    @Autowired
    IUserService userService;

    @GetMapping("/notifriend/{id}")
    public ResponseEntity<?> getNotiByFriendRequest(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(friendReques.findFriendRequestByUserReceiverAndSttIsFalse(user), HttpStatus.OK);
    }
}
