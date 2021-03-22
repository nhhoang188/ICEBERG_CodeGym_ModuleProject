package com.icebergsocialnetwork.services.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService extends IGenericService<Post> {

    Page<Post> findPostByUserIdOrderByCreateDateDesc(Long id, Pageable pageable);


}
