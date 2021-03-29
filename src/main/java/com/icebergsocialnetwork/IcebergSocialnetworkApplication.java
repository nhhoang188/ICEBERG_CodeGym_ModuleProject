package com.icebergsocialnetwork;

import com.icebergsocialnetwork.services.friend.FriendRequestService;
import com.icebergsocialnetwork.services.friend.IFriendReques;
import com.icebergsocialnetwork.services.like.ILove;
import com.icebergsocialnetwork.services.like.ILoveComment;
import com.icebergsocialnetwork.services.like.LoveCommentServiceImpl;
import com.icebergsocialnetwork.services.like.LoveServiceImpl;
import com.icebergsocialnetwork.services.post.PostService;
import com.icebergsocialnetwork.services.post.PostServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IcebergSocialnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcebergSocialnetworkApplication.class, args);
    }
    @Bean
    public IFriendReques iFriendReques(){
        return new FriendRequestService();
    }
    @Bean
    public ILove iLove(){
        return new LoveServiceImpl();
    }
    @Bean
    public ILoveComment iLoveComment(){
        return new LoveCommentServiceImpl();
    }


    @Bean
    public PostService postService(){
        return new PostServiceImpl();
    }

}
