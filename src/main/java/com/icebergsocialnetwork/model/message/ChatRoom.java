package com.icebergsocialnetwork.model.message;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin("*")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "first_user_id",insertable = false,updatable = false)
    private User firstUser;

    private Long first_user_id;

    @ManyToOne
    @JoinColumn(name = "second_user_id",insertable = false,updatable = false)
    private User secondUser;

    private Long second_user_id;

    public ChatRoom() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public Long getFirst_user_id() {
        return first_user_id;
    }

    public void setFirst_user_id(Long first_user_id) {
        this.first_user_id = first_user_id;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public Long getSecond_user_id() {
        return second_user_id;
    }

    public void setSecond_user_id(Long second_user_id) {
        this.second_user_id = second_user_id;
    }

    public ChatRoom(Long id, String name, User firstUser, Long first_user_id, User secondUser, Long second_user_id) {
        this.id = id;
        this.name = name;
        this.firstUser = firstUser;
        this.first_user_id = first_user_id;
        this.secondUser = secondUser;
        this.second_user_id = second_user_id;
    }

}
