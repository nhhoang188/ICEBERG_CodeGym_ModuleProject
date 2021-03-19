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

//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<Post> createStatus(@RequestBody Post post) {
//        Post status = postService.save(post);
//        ResponseEntity responseEntity = new ResponseEntity(status, HttpStatus.CREATED);
//        return responseEntity;
//    }

    @GetMapping("/posts")
    public ResponseEntity<Iterable<Post>> getAll(){
        return new ResponseEntity<>(postService.findAll(),HttpStatus.OK);
    }
}
