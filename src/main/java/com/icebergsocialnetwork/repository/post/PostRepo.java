package com.icebergsocialnetwork.repository.post;

import com.icebergsocialnetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepo extends PagingAndSortingRepository<Post, Long> {
}
