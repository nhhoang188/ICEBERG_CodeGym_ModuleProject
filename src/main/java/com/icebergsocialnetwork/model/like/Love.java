package com.icebergsocialnetwork.model.like;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;

import javax.persistence.*;


@Entity
public class Love {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Love(Long id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public Love() { };

    public Love(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
