package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.like.LoveComment;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoveCommentRepository extends JpaRepository<LoveComment,Long> {
    LoveComment findByCommentAndUser (Comment comment, User user);
    int countAllByComment(Comment comment);

    Iterable<LoveComment> findAllByComment(Comment comment);
}
