package com.icebergsocialnetwork.repository.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
    Iterable<Comment> findAllCommentByPostId(Long postId);


    @Modifying
    @Query("delete from LoveComment lc " +
            "where lc.comment.commentId = ?1")
    int deleteLoveComment(Long commentId);


    @Modifying
    @Query("delete from Comment c " +
            "where c.commentId = ?1 and c.postId = ?2 and c.userId = ?3")
    int deleteComment(Long commentId, Long postId, Long userId);


    @Modifying
    @Query("select lc.user.id " +
            "from LoveComment lc " +
            "where lc.comment.commentId =?1")
    List<Long> findUserId(Long commentId);


    @Modifying
    @Query("update Comment " +
            "set content = ?1 " +
            "where commentId = ?2 and postId = ?3")
    int updateComment(String content, Long commentId, Long postId);


    @Query("select u.fullname from User u where u.id =?1")
    String findNameUser(Long userId);

    Comment findCommentByCommentId(Long commentId);

}
