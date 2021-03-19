package com.icebergsocialnetwork.controller.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import com.icebergsocialnetwork.services.like.ILove;
import com.icebergsocialnetwork.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/loves")
public class LoveController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private PostService postService;
    @Autowired
    private ILove iLove;

    @PostMapping
    public void like(@RequestBody Love love) {
        iLove.save(love);
    }

    @DeleteMapping("/{id}")
    public void unlike(@PathVariable Long id) {
        iLove.deleteById(id);
    }

    @GetMapping
    public Iterable<Love> getAll() {
        return iLove.findAll();
    }

    @GetMapping("/find")
    public Love findByPostAndUser(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2) {
        Love love;
        Post post;
        User user;
        try{
            post = postService.findById(id1);
            user = iUserService.findById(id2);
            love =  iLove.findByPostAndUser(post, user);
            return love;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/count/{id}")
    public int countLikeByPost(@PathVariable Long id){
        Post post=postService.findById(id);
        return iLove.countAllByPost(post);
    }
}
