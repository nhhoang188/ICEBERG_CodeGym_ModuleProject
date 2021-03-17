package com.icebergsocialnetwork.services.ImplServices;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.repository.like.FriendRequestRepository;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FriendRequestService implements IFriendReques {
    @Autowired
    private FriendRequestRepository friendRequestRepository;

//    @Override
//    public Page<FriendRequest> findAll(Pageable pageable) {
//        return friendRequestRepository.findAll(pageable);
//    }
//
    @Override
    public Iterable<FriendRequest> findAll() {
        return friendRequestRepository.findAll();
    }

    @Override
    public Optional<FriendRequest> findById(Long id) {
        return friendRequestRepository.findById(id);
    }

    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        return friendRequestRepository.save(friendRequest);
    }

    @Override
    public void deleteById(Long id) {
        friendRequestRepository.deleteById(id);
    }

    @Override
    public void delete(FriendRequest friendRequest) {
        friendRequestRepository.delete(friendRequest);
    }
}
