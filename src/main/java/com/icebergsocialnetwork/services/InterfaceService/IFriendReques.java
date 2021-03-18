package com.icebergsocialnetwork.services.InterfaceService;

import com.icebergsocialnetwork.model.like.FriendRequest;


import java.util.Optional;

public interface IFriendReques {
    void delete(FriendRequest friendRequest);

    Iterable<FriendRequest> findAll();

    FriendRequest save(FriendRequest friendRequest);

    Optional<FriendRequest> findById(Long id);

    void deleteById(Long id);

    FriendRequest findAllByUserSender(Long id1, Long id2);
}
