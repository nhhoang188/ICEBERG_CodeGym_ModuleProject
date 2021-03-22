package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

    @Query(nativeQuery = true,value ="select * from friend_request where (user_receiver_id=:id1 and user_sender_id=:id2 ) or(user_receiver_id=:id2 and user_sender_id=:id1 )")
    FriendRequest findAllByUserSender (Long id1,Long id2);

    List<FriendRequest> findAllByUserReceiverOrUserSender(User user1, User user2);
}
