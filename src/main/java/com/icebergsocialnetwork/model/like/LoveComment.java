package com.icebergsocialnetwork.model.like;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;

import javax.persistence.*;

@Entity
public class LoveComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public LoveComment(Long id, User user, Comment comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }

    public LoveComment(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public LoveComment() {
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
