package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.like.LoveComment;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.repository.like.LoveCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class LoveCommentServiceImpl implements ILoveComment {
    @Autowired
    public LoveCommentRepository loveCommentRepository;
    @Override
    public LoveComment findByCommentAndUser(Comment comment, User user) {
        return loveCommentRepository.findByCommentAndUser(comment,user);
    }

    @Override
    public int countAllByComment(Comment comment) {
        loveCommentRepository.countAllByComment(comment);
        return loveCommentRepository.countAllByComment(comment);
    }

    @Override
    public Iterable<LoveComment> findAllByComment(Comment comment) {
        return loveCommentRepository.findAllByComment(comment);
    }

    @Override
    public Page<LoveComment> findAll(Pageable pageable) {
        return loveCommentRepository.findAll(pageable);
    }

    @Override
    public Iterable<LoveComment> findAll() {
        return loveCommentRepository.findAll();
    }

    @Override
    public LoveComment findById(Long id) {
        Optional<LoveComment> loveComment=loveCommentRepository.findById(id);
        return loveComment.orElse(null);
    }

    @Override
    public LoveComment save(LoveComment loveComment) {
        return loveCommentRepository.save(loveComment);
    }

    @Override
    public void deleteById(Long id) {
        loveCommentRepository.deleteById(id);
    }
}
