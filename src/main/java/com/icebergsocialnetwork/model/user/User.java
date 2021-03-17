package com.icebergsocialnetwork.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    @Column(name = "birthday")
    private Date birthDay;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
