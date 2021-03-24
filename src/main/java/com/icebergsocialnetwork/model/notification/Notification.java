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

    @Column(name = "friendrequestid")
    private Long friendRequestId;
}
