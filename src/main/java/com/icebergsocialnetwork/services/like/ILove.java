package com.icebergsocialnetwork.services.like;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.IGenericService;

import java.util.List;

public interface ILove extends IGenericService<Love> {
    Love findByPostAndUser (Post post, User user);
    int countAllByPost(Post post);
    List<Love> findAllByPost(Post post);
    void deleteByUserId(Long userId);

}
