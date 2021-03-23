package com.icebergsocialnetwork.controller.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.ImplServices.UserService;
import com.icebergsocialnetwork.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    //region api status post
    @PostMapping
    @ResponseBody
    public ResponseEntity<Post> createStatus(@RequestBody Post post) {
        Post status = postService.save(post);
        return new ResponseEntity(status, HttpStatus.CREATED);
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
            postEdit.setImage(post.getImage());
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable("userId") Long userId,@PageableDefault Pageable pageable) {
        User user = userService.findById(userId);
        List<Post> getAll = postService.findPostByUserIdOrderByCreateDateDesc(userId, pageable).getContent();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable("id") Long id){
        Post post = postService.findById(id);
        if (post != null){
            postService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<Post> editImagePostStatus(@PathVariable("id") Long id, @RequestBody Post post) {
        Post postEdit = postService.findById(id);
        if (postEdit != null) {
            postEdit.setContent(post.getContent());
            postEdit.setCreateDate(post.getCreateDate());
            postEdit.setPrivacy(post.getPrivacy());
            postEdit.setImage(null);
            postService.save(postEdit);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //endregion
}