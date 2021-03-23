package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.comment.Comment;

import com.icebergsocialnetwork.model.like.LoveComment;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.IGenericService;

public interface ILoveComment extends IGenericService<LoveComment> {
    LoveComment findByCommentAndUser (Comment comment, User user);
    int countAllByComment(Comment comment);

    Iterable<LoveComment> findAllByComment(Comment post);
}
