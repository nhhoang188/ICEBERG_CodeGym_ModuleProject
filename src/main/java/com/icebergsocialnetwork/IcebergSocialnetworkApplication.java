package com.icebergsocialnetwork;

import com.icebergsocialnetwork.services.ImplServices.FriendRequestService;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import com.icebergsocialnetwork.services.like.ILove;
import com.icebergsocialnetwork.services.like.LoveServiceImpl;
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

}
