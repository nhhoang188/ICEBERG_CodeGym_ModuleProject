package com.icebergsocialnetwork.repository.user;

import com.icebergsocialnetwork.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);

    User findUserById(Long id);
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT * \n" +
            "FROM user where user.username <> ?1", nativeQuery = true)
    List<User> getFriends(String username);

    User findUserByIdAndInfomodifierIsTrue(Long id);

    @Modifying
    @Query("UPDATE User a SET a.userStatus = TRUE WHERE a.username = ?1")
    int lockUser(String username);

    @Modifying
    @Query("UPDATE User a SET a.userStatus = FALSE WHERE a.username = ?1")
    int unlockUser(String username);
}
