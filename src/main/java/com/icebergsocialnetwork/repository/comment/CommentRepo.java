package com.icebergsocialnetwork.repository.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
}
