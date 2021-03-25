package com.icebergsocialnetwork.model.notification;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private Long UserId;

    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "cmt_id")
    private Long comment;

    @Column(name = "post_id")
    private Long post;

}
