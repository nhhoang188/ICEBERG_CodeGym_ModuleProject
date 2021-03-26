package com.icebergsocialnetwork.model.message;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.icebergsocialnetwork.model.user.User;

import javax.persistence.*;

@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Transient
//    private MessageType type;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_sender_id",insertable = false,updatable = false)
    private User sender;

    private Long user_sender_id;

    @ManyToOne
    @JoinColumn(name = "user_receiver_id",insertable = false,updatable = false)
    private User receiver;

    private Long user_receiver_id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id",insertable = false,updatable = false)
    private ChatRoom chatRoom;

    private Long chat_room_id;
//
//    public MessageType getType() {
//        return type;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }


    public ChatMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Long getUser_sender_id() {
        return user_sender_id;
    }

    public void setUser_sender_id(Long user_sender_id) {
        this.user_sender_id = user_sender_id;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Long getUser_receiver_id() {
        return user_receiver_id;
    }

    public void setUser_receiver_id(Long user_receiver_id) {
        this.user_receiver_id = user_receiver_id;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Long getChat_room_id() {
        return chat_room_id;
    }

    public void setChat_room_id(Long chat_room_id) {
        this.chat_room_id = chat_room_id;
    }

    public ChatMessage(int id, String content, User sender, Long user_sender_id, User receiver, Long user_receiver_id, ChatRoom chatRoom, Long chat_room_id) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.user_sender_id = user_sender_id;
        this.receiver = receiver;
        this.user_receiver_id = user_receiver_id;
        this.chatRoom = chatRoom;
        this.chat_room_id = chat_room_id;
    }
}
