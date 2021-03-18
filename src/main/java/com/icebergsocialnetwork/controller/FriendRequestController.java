package com.icebergsocialnetwork.controller;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/friendrequests")
public class FriendRequestController {
    @Autowired
    private IFriendReques iFriendReques;

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
    public FriendRequest check(@RequestParam("id") Long id, @RequestParam("id2") Long id2) {
        return iFriendReques.findAllByUserSender(id, id2);
    }

}
