package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LoveRepository extends JpaRepository<Love, Long> {
    Love findByPostAndUser(Post post, User user);

    int countAllByPost(Post post);

    List<Love> findAllByPost(Post post);

    @Modifying
    @Query("DELETE from Love l where l.post.postId = ?1")
    void deleteLoveByPostid(Long id);
}
