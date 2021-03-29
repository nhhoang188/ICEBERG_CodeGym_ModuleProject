package com.icebergsocialnetwork.controller.message;

import com.icebergsocialnetwork.model.message.ChatRoom;
import com.icebergsocialnetwork.services.user.Impl.UserService;
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
    @Autowired
    private UserService userService;

    @GetMapping("/{first_user_id}/{second_user_id}")
    public ChatRoom getRoomByIds(@PathVariable("first_user_id") long first_user_id, @PathVariable("second_user_id") long second_user_id) {
        Optional<ChatRoom> chatRoom = chatRoomService.getChatRoomByIds(first_user_id, second_user_id);
        if (chatRoom.isPresent()) {
            return chatRoomService.getChatRoomByIds(first_user_id, second_user_id).get();
        }
        return null;
    }

    @PostMapping("/{id1}/{id2}")
    public void createChatRoom(@PathVariable Long id1,@PathVariable Long id2){
        ChatRoom chatRoom=new ChatRoom();
        chatRoom.setFirst_user_id(id1);
        chatRoom.setSecond_user_id(id2);
        String name="/message/"+id1+"/"+id2;
        chatRoom.setName(name);
        chatRoom.setFirstUser(userService.findById(id1));
        chatRoom.setSecondUser(userService.findById(id2));

        chatRoomService.save(chatRoom);
    }
}