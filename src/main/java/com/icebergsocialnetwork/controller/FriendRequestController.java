package com.icebergsocialnetwork.controller;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/friendRequess")
public class FriendRequestController {
    @Autowired
    private IFriendReques iFriendReques;

    @GetMapping
    public Iterable<FriendRequest> getAll(){
        return iFriendReques.findAll();
    }
    @PostMapping
    public void create(@RequestBody FriendRequest friendRequest){
        friendRequest.setStt(false);
        iFriendReques.save(friendRequest);
    }
    @DeleteMapping
    public void delete(@RequestBody FriendRequest friendRequest){
        iFriendReques.delete(friendRequest);
    }

    @PutMapping("/{id}")
    public void acceptFriend(@PathVariable Long id){
        Optional<FriendRequest> check=iFriendReques.findById(id);
        FriendRequest friendRequest=new FriendRequest();
        if(check.isPresent()){
            friendRequest= check.get();
            friendRequest.setStt(true);
            iFriendReques.save(friendRequest);
        }
    }

}
