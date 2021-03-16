package com.icebergsocialnetwork.services.InterfaceService;

import com.icebergsocialnetwork.model.like.FriendRequest;

import java.util.Optional;

public interface IFriendReques  {
    void delete(FriendRequest friendRequest);
    public Iterable<FriendRequest> findAll();
    public FriendRequest save(FriendRequest friendRequest);
    public Optional<FriendRequest> findById(Long id);
}
