package com.icebergsocialnetwork.model.like;

import com.icebergsocialnetwork.model.user.User;

import javax.persistence.*;

@Entity
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_sender_id")
    private User userSender;

    @ManyToOne
    @JoinColumn(name = "user_receiver_id")
    private User userReceiver;
    private boolean stt;

    public FriendRequest() {
    }

    public FriendRequest(User userSender, User userReceiver, boolean stt) {
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.stt = stt;
    }

    public FriendRequest(Long id, User userSender, User userReceiver, boolean stt) {
        this.id = id;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.stt = stt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public boolean isStt() {
        return stt;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }
}
