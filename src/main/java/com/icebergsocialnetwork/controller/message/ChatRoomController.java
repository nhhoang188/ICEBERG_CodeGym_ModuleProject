package com.icebergsocialnetwork.controller.message;

import com.icebergsocialnetwork.model.message.ChatRoom;
import com.icebergsocialnetwork.services.message.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/{first_user_id}/{second_user_id}")
    public ChatRoom getRoomByIds(@PathVariable("first_user_id") long first_user_id, @PathVariable("second_user_id") long second_user_id) {
        Optional<ChatRoom> chatRoom = chatRoomService.getChatRoomByIds(first_user_id, second_user_id);
        if (chatRoom.isPresent()) {
            return chatRoomService.getChatRoomByIds(first_user_id, second_user_id).get();
        }
        return null;
    }

    @PostMapping()
    public void createChatRoom(@RequestBody ChatRoom chatRoom){
        chatRoomService.save(chatRoom);
    }
}