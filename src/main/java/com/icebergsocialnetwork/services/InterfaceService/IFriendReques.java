package com.icebergsocialnetwork.services.InterfaceService;

import com.icebergsocialnetwork.model.like.FriendRequest;

import java.util.List;
import java.util.Optional;

public interface IFriendReques  {
    void delete(FriendRequest friendRequest);
    public Iterable<FriendRequest> findAll();
    public FriendRequest save(FriendRequest friendRequest);
    public Optional<FriendRequest> findById(Long id);
    public void deleteById(Long id);
    public FriendRequest findAllByUserSender(Long id1,Long id2);
}
