package com.icebergsocialnetwork.controller.message;

import com.icebergsocialnetwork.model.message.ChatMessage;
import com.icebergsocialnetwork.services.message.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/{room_chat_id}")
    public List<ChatMessage> getChatMessages(@PathVariable Long room_chat_id) {
        List<ChatMessage> list;
        try {
            list=chatMessageService.getChatMessageByChatRoom(room_chat_id);
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}