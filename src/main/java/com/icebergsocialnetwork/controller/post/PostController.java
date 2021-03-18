package com.icebergsocialnetwork.controller.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.post.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    //region api status post
    @PostMapping
    @ResponseBody
    public ResponseEntity<Post> createStatus(@RequestBody Post post) {
        Post status = postService.save(post);
        return new ResponseEntity(status, HttpStatus.CREATED);
    }
    //endregion
}
