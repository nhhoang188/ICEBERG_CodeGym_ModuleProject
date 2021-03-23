package com.icebergsocialnetwork.controller.comment;

import com.icebergsocialnetwork.dto.ResponeMessenger;
import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createComment(@Valid @RequestBody Comment comment) {
        String content = comment.getContent();
        if (content == null || content == "") {
            return new ResponseEntity<>(new ResponeMessenger("no"),HttpStatus.OK);
        }
        Comment cm = commentService.save(comment);
        return new ResponseEntity<>(cm, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    @ResponseBody
    public ResponseEntity<List<Comment>> findAllCommentByPostId(@PathVariable("postId") Long postId) {
        List<Comment> comments = (List<Comment>) commentService.findAllCommentByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
