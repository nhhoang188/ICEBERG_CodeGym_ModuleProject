package com.icebergsocialnetwork.services.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService extends IGenericService<Post> {
    Page<Post> findPostByUserIdOrderByCreateDateDesc(Long id, Pageable pageable);

    Post findPostByPostId(Long postId);

    List<Post> findPostByUserId(Long userId);
    List<Post> findAllPostInTimeLine(Long id);
}
