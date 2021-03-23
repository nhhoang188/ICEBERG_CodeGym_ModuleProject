package com.icebergsocialnetwork.repository.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
}