package com.icebergsocialnetwork.repository.notification;

import com.icebergsocialnetwork.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NotificationRepo extends JpaRepository<Notification, Long> {

    @Modifying
    @Query(" select n from Notification n where ?1 = n.UserId GROUP BY n.post")
    Notification findNotiByPost(Long id);

    @Modifying
    @Query(" select n from Notification n GROUP BY n.post")
    List<Notification> findNotiGroupByPost();
}
