package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

    @Query(nativeQuery = true, value = "select * from friend_request where (user_receiver_id=:id1 and user_sender_id=:id2 ) or(user_receiver_id=:id2 and user_sender_id=:id1 )")
    FriendRequest findAllByUserSender(Long id1, Long id2);

    List<FriendRequest> findAllByUserReceiverOrUserSender(User user1, User user2);

    List<FriendRequest> findFriendRequestByUserReceiverAndSttIsFalse(User userReceiver);

    @Modifying
    @Query(" select l from FriendRequest l where ( (l.userReceiver.id= ?1 and l.userSender.id = ?2) or (l.userSender.id= ?1 and l.userReceiver.id = ?2)) and l.stt = true")
    boolean checkFriend(Long id1, Long id2);


    @Query(nativeQuery = true, value = "select * from friend_request where ( (user_receiver_id=:id1 and user_sender_id=:id2 ) or(user_receiver_id=:id2 and user_sender_id=:id1 ) ) and stt is true")
    boolean checkFriendNative(Long id1, Long id2);
}
