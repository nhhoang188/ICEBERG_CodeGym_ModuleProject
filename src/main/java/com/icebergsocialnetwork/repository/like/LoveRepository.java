package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoveRepository extends JpaRepository<Love, Long> {
    Love findByPostAndUser (Post post, User user);
    int countAllByPost(Post post);
}
