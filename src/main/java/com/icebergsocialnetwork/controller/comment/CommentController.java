package com.icebergsocialnetwork.controller.comment;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
       Comment cm = commentService.save(comment);
       if(cm != null){
           return new ResponseEntity<>(HttpStatus.CREATED);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
