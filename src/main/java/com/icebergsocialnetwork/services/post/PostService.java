package com.icebergsocialnetwork.services.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.IGenericService;

import java.util.List;

public interface PostService extends IGenericService<Post> {

    List<Post> findAllByUserId(Long id);
}
