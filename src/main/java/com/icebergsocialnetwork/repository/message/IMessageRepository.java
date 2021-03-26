package com.icebergsocialnetwork.repository.message;

import com.icebergsocialnetwork.model.message.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMessageRepository extends JpaRepository<ChatMessage, Long> {
    @Query(value = "select * " +
            "from chat_message " +
            "where chat_room_id =?1", nativeQuery = true)
    List<ChatMessage> getChatMessageByChatRoom(Long chatRoomId);

}