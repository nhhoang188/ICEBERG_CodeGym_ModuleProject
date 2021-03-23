package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.repository.like.LoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class LoveServiceImpl implements ILove{
    @Autowired
    public LoveRepository loveRepository;
    @Override
    public Page<Love> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Love> findAll() {
        return loveRepository.findAll();
    }

    @Override
    public Love findById(Long id) {
        return loveRepository.findById(id).get();
    }

    @Override
    public Love save(Love love) {
        return loveRepository.save(love);
    }

    @Override
    public void deleteById(Long id) {
        loveRepository.deleteById(id);

    }

    @Override
    public Love findByPostAndUser(Post post, User user) {
        return loveRepository.findByPostAndUser(post, user);
    }

    @Override
    public int countAllByPost(Post post) {
        return loveRepository.countAllByPost(post);
    }

    @Override
    public List<Love> findAllByPost(Post post) {
        return loveRepository.findAllByPost(post);
    }

    @Override
    public void deleteLoveByPostid(Long id) {
        loveRepository.deleteLoveByPostid(id);
    }


}
