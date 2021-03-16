package com.icebergsocialnetwork.repository.like;

import com.icebergsocialnetwork.model.like.FriendRequest;
import com.icebergsocialnetwork.model.like.IFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {



}
