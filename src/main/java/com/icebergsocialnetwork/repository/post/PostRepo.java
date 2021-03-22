package com.icebergsocialnetwork.repository.post;

import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepo extends PagingAndSortingRepository<Post, Long> {

    Iterable<Post> findAllPostByUserId(Long userId);
}
