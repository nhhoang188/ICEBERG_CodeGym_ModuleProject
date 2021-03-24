package com.icebergsocialnetwork.services.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.IGenericService;
import java.util.*;

public interface CommentService extends IGenericService<Comment> {
    Iterable<Comment> findAllCommentByPostId(Long postId);

    int deleteLoveComment(Long commentId);

    int deleteComment(Long commentId, Long postId, Long userId);

    List<Long> findUserId(Long commentId);
}
