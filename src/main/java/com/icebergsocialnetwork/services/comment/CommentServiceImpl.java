package com.icebergsocialnetwork.services.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.repository.comment.CommentRepo;
import com.icebergsocialnetwork.repository.like.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private FriendRequestRepository friendRequestRepository;

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
        return null;
    }

    @Override
    public Comment save(Comment comment) {

        boolean status = checkFriend(, comment.getUserId());

        return null;
    }

    private boolean checkFriend(Long id1, Long id2) {
        friendRequestRepository.findAllByUserSender(id1, id2);
    }

    @Override
    public void deleteById(Long id) {

    }
}
