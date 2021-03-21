package com.icebergsocialnetwork.model.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private Long userId;
    private Date createDate;
    private String privacy;
    private String content;
    private String image;

    public Post(Long postId, Long userId, Date createDate, String privacy, String content) {
        this.postId = postId;
        this.userId = userId;
        this.createDate = createDate;
        this.privacy = privacy;
        this.content = content;
    }

    public Post() {
    }

    public Post(Long postId, Long userId, Date createDate, String privacy, String content, String image) {
        this.postId = postId;
        this.userId = userId;
        this.createDate = createDate;
        this.privacy = privacy;
        this.content = content;
        this.image = image;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
