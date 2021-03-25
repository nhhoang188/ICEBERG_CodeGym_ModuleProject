package com.icebergsocialnetwork.controller;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/friendrequests")
public class FriendRequestController {
    @Autowired
    private IFriendReques iFriendReques;
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public Iterable<FriendRequest> getAll() {
        return iFriendReques.findAll();
    }

    @GetMapping("/{id}")
    public FriendRequest getById(@PathVariable Long id) {
        Optional<FriendRequest> check = iFriendReques.findById(id);
        return check.orElse(null);
    }

    @PostMapping
    public void create(@RequestBody FriendRequest friendRequest) {
        friendRequest.setStt(false);
        iFriendReques.save(friendRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iFriendReques.deleteById(id);
    }

    @PutMapping("/{id}")
    public void acceptFriend(@PathVariable Long id, @RequestBody FriendRequest friendRequest) {
        iFriendReques.save(friendRequest);
    }

    @GetMapping("/check")
    public FriendRequest checkFriend(@RequestParam("id") Long id, @RequestParam("id2") Long id2) {
        return iFriendReques.findAllByUserSender(id, id2);
    }

    @GetMapping("/listfriend/{id}")
    public List<User> showListFriend(@PathVariable Long id) {
        User user = iUserService.findById(id);
        return iFriendReques.findListFriendbyUser(user);
    }

    @GetMapping("/listsimilarfriend/{id1}/{id2}")
    public List<User> findAllSimilarFriend(@PathVariable Long id1, @PathVariable Long id2) {
        User user1 = iUserService.findById(id1);
        User user2 = iUserService.findById(id2);
        return iFriendReques.findAllSimilarFriend(user1, user2);
    }

}
