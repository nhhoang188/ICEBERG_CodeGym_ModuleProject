package com.icebergsocialnetwork.services.ImplServices;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.repository.like.FriendRequestRepository;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FriendRequestService implements IFriendReques {
    @Autowired
    private FriendRequestRepository friendRequestRepository;

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

    @Override
    public FriendRequest findAllByUserSender(Long id1,Long id2) {
        return friendRequestRepository.findAllByUserSender(id1,id2);
    }
    @Override
    public List<FriendRequest> findAllByUserReceiverOrUserSender(User user1, User user2) {
        List<FriendRequest> list= friendRequestRepository.findAllByUserReceiverOrUserSender(user1,user2);
        int size= list.size();
        for (int j = size-1; j >=0; j--) {
            if (!list.get(j).isStt()) {
                list.remove(list.get(j));
            }
        } return list;
    }
}
