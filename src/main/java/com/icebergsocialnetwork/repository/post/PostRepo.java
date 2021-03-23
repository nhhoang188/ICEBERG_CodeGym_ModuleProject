package com.icebergsocialnetwork.repository.post;

import com.icebergsocialnetwork.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findPostByUserIdOrderByCreateDateDesc(Long id, Pageable pageable);

    Post findPostByPostId(Long postId);

    List<Post> findPostByUserId(Long userId);
}
