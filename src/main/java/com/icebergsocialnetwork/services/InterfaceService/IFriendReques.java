package com.icebergsocialnetwork.services.InterfaceService;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.user.User;


import java.util.List;
import java.util.Optional;

public interface IFriendReques {
    void delete(FriendRequest friendRequest);

    Iterable<FriendRequest> findAll();

    FriendRequest save(FriendRequest friendRequest);

    Optional<FriendRequest> findById(Long id);

    void deleteById(Long id);

    FriendRequest findAllByUserSender(Long id1, Long id2);

    List<FriendRequest> findAllByUserReceiverOrUserSender(User user1, User user2);

    List<User> findListFriendbyUser(User user);

    List<User> findAllSimilarFriend(User user1, User user2);

    List<FriendRequest> findFriendRequestByUserReceiverAndSttIsFalse(User userReceiver);

    boolean checkFriend(Long id1, Long id2);
    boolean checkFriendNative(Long id1, Long id2);

}
