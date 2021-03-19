package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.Love;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoveRepository extends JpaRepository<Love, Long> {
    Love findLoveByPost_PostIdAndUser_Id (Long id, Long id2);

}
