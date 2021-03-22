package com.icebergsocialnetwork.controller.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.services.post.PostService;
import com.icebergsocialnetwork.services.post.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    //region api status post
    @PostMapping
    @ResponseBody
    public ResponseEntity<Post> createStatus(@RequestBody Post post) {
        Post status = postService.save(post);
        ResponseEntity responseEntity = new ResponseEntity(status, HttpStatus.CREATED);
        return responseEntity;
    }
    //endregion

    //region api edit post
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity editPostStatus(@PathVariable("id") Long id, @RequestBody Post post) {
        Post postEdit = postService.findById(id);
        if (postEdit != null) {
            postEdit.setContent(post.getContent());
            postEdit.setCreateDate(post.getCreateDate());
            postEdit.setPrivacy(post.getPrivacy());
            postService.save(postEdit);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //endregion
    //region api get a post by id
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Post> findPostById(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    //endregion

    //region findAllPostByUserId
    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Post>> findAllPostByUserId() {
        //fake userId = 1;
        Long userId = 1L;
        List<Post> postList = (List<Post>) postService.findAllPostByUserId(userId);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
    //endregion

    //region delete a status by  id
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteStatusById(@PathVariable("id") Long id) {
        Post post = postService.findById(id);
        if (post == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        postService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    //endregion

}
