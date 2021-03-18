package com.icebergsocialnetwork.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean userStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
