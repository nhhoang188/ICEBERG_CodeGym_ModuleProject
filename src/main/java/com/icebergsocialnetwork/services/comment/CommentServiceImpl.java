package com.icebergsocialnetwork.services.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.repository.comment.CommentRepo;
import com.icebergsocialnetwork.repository.like.FriendRequestRepository;
import com.icebergsocialnetwork.repository.post.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private PostRepo postRepo;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> comment = commentRepo.findById(id);
        return comment.orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        Long userOwnerId = postRepo.findPostByPostId(comment.getPostId()).getUserId();

        if (userOwnerId == comment.getUserId()) {
            commentRepo.save(comment);
            return comment;
        } else {
            try {
                boolean status = checkFriend(userOwnerId, comment.getUserId());
                if (status) {
                    commentRepo.save(comment);
                    return comment;
                }
                return null;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }

        }
    }

    private boolean checkFriend(Long id1, Long id2) {
        return friendRequestRepository.findAllByUserSender(id1, id2).isStt();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Iterable<Comment> findAllCommentByPostId(Long postId) {
        List<Comment> comments = (List<Comment>) commentRepo.findAllCommentByPostId(postId);
        return comments;
    }

    @Override
    public int deleteLoveComment(Long commentId) {
        int result = commentRepo.deleteLoveComment(commentId);
        return result;
    }

    @Override
    public int deleteComment(Long commentId, Long postId, Long userId) {

        int status = deleteLoveComment(commentId);
        if (status > 0) {
            commentRepo.deleteComment(commentId, postId, userId);
            return 1;
        }

        return 0;
    }

    @Override
    public List<Long> findUserId(Long commentId) {
        return commentRepo.findUserId(commentId);
    }
}
