package com.icebergsocialnetwork.controller.notification;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.notification.Notification;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import com.icebergsocialnetwork.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping
public class NotificationApi {
    @Autowired
    IFriendReques friendReques;
    @Autowired
    IUserService userService;
    @Autowired
    NotificationService notificationService;

    @GetMapping("/notifriend/{id}")
    public ResponseEntity<?> getNotiByFriendRequest(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(friendReques.findFriendRequestByUserReceiverAndSttIsFalse(user), HttpStatus.OK);
    }


    @GetMapping("/notipost/{id}")
    public ResponseEntity<?> getNotiByNotiFriend(@PathVariable("id") Long id) {
        return new ResponseEntity<>(notificationService.findNotiByCmtOfMyPost(id), HttpStatus.OK);
    }

    @GetMapping("/notilove/{id}")
    public ResponseEntity<?> getNotiByLoveOfMyPost(@PathVariable("id") Long id) {
        return new ResponseEntity<>(notificationService.findNotiByLoveOfMyPost(id), HttpStatus.OK);
    }
}
