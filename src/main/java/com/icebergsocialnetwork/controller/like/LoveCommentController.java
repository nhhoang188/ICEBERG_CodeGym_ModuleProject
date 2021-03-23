package com.icebergsocialnetwork.controller.like;


import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.like.LoveComment;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import com.icebergsocialnetwork.services.comment.CommentService;
import com.icebergsocialnetwork.services.like.ILoveComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/lovecomments")
public class LoveCommentController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ILoveComment iLoveComment;
    @PostMapping
    public void like(@RequestBody LoveComment love) {
        iLoveComment.save(love);
    }

    @DeleteMapping("/{id}")
    public void unlike(@PathVariable Long id) {
        iLoveComment.deleteById(id);
    }

    @GetMapping
    public Iterable<LoveComment> getAll() {
        return iLoveComment.findAll();
    }

    @GetMapping("/find")
    public LoveComment checkByCommentAndUser(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2) {
        LoveComment love;
        Comment comment;
        User user;
        try{
            comment = commentService.findById(id1);
            user = iUserService.findById(id2);
            love =  iLoveComment.findByCommentAndUser(comment, user);
            return love;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/count/{id}")
    public int countLikeByComment(@PathVariable Long id){
        Comment comment=commentService.findById(id);
        return iLoveComment.countAllByComment(comment);
    }

    @GetMapping("/list/{id}")
    public Iterable<LoveComment> findAllByComment(@PathVariable Long id ){
        Comment post= commentService.findById(id);
        if(post!=null){
            return iLoveComment.findAllByComment(post);
        }else return null;
    }
}
