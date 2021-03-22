package com.icebergsocialnetwork.services.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.IGenericService;

import java.util.Iterator;

public interface PostService extends IGenericService<Post> {
    Iterable<Post> findAllPostByUserId(Long userId);
}
