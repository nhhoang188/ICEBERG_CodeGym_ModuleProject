package com.icebergsocialnetwork.repository.message;

import com.icebergsocialnetwork.model.message.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query(value = "select * " +
            "from chat_room " +
            "where (first_user_id = ?1 and second_user_id = ?2) " +
            "or (first_user_id = ?2 and second_user_id = ?1)" , nativeQuery = true)
    Optional<ChatRoom> getChatRoomByIds(Long firstUserId, Long secondUserId);

    Optional<ChatRoom> findByName( String name);
}