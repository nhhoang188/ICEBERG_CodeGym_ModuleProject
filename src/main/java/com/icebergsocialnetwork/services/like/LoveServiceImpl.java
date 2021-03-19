package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.repository.like.LoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Love findByUser_Id(Long id) {
        return null;
    }
}
