package com.icebergsocialnetwork.repository.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.icebergsocialnetwork.repository.like.LoveCommentRepository;
public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
    Iterable<Comment> findAllCommentByPostId(Long postId);

    // delete a specific row in table LoveComment
//    @Modifying
//    @Query("delete from LoveComment lc where lc.")
//    boolean deleteLoveComment();
}
