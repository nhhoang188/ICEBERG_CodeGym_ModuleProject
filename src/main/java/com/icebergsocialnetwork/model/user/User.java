package com.icebergsocialnetwork.model.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @Size(min=6,max=100)
    private String password;
    @Email
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String imgcover;
    private String fullname;
    private String description;
    private String bio;
    private boolean accessmodifier;
    private boolean infomodifier;
    @Column(name = "birthday")
    private Date birthDay;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    private boolean userStatus;

//    @OneToMany(targetEntity = User.class)
//    private List<User> listFriend;

    public User() {
    }

    public User(Long id, String username, String password, String email, String phone, Date birthDay, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.roles = roles;
    }

    public User(Long id, String username, String password, String email, String phone, Date birthDay, Set<Role> roles, boolean userStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.roles = roles;
        this.userStatus = userStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImgcover() {
        return imgcover;
    }

    public void setImgcover(String imgcover) {
        this.imgcover = imgcover;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isAccessmodifier() {
        return accessmodifier;
    }

    public void setAccessmodifier(boolean accessmodifier) {
        this.accessmodifier = accessmodifier;
    }

    public boolean isInfomodifier() {
        return infomodifier;
    }

    public void setInfomodifier(boolean infomodifier) {
        this.infomodifier = infomodifier;
    }

    public boolean isUserStatus() {
        return userStatus;
    }
}
