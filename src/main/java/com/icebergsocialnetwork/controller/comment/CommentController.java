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
            return new ResponseEntity<>(new ResponeMessenger("no"), HttpStatus.OK);
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

    @DeleteMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity deleteComment(@PathVariable("commentId") Long commentId) {
        int status = commentService.deleteComment(commentId);
        if (status == 1) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity<Integer> updateComment(@PathVariable("commentId") Long commentId,@RequestBody Comment comment) {
        Comment commentOld = commentService.findCommentByCommentId(commentId);
        if (commentOld != null) {
            int updateComment = commentService.updateComment(comment.getContent(),
                    comment.getCommentId(),
                    comment.getPostId());
            return new ResponseEntity<>(updateComment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{postId}/edit-comment/{commentId}")
    @ResponseBody
    public ResponseEntity<Comment> findCommentByCommentId(@PathVariable("postId") Long postId,
                                                          @PathVariable("commentId") Long commentId) {
        Comment comment = commentService.findCommentByCommentId(commentId);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
