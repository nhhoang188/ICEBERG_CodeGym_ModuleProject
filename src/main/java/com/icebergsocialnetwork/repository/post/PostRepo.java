package com.icebergsocialnetwork.repository.post;

import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepo extends PagingAndSortingRepository<Post, Long> {

    List<Post> findAllByUserId(Long id);
}
