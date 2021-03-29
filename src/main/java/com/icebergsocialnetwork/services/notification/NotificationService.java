package com.icebergsocialnetwork.services.notification;

import com.icebergsocialnetwork.model.comment.Comment;
import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.model.notification.Notification;
import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.repository.notification.NotificationRepo;
import com.icebergsocialnetwork.services.friend.IFriendReques;
import com.icebergsocialnetwork.services.user.IUserService;
import com.icebergsocialnetwork.services.comment.CommentService;
import com.icebergsocialnetwork.services.like.ILove;
import com.icebergsocialnetwork.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    IFriendReques friendReques;
    @Autowired
    IUserService userService;
    @Autowired
    INotificationService notificationService;
    @Autowired
    PostService postService;
    @Autowired
    ILove lovesv;

    @Autowired
    CommentService commentService;

    @Override
    public Page<Notification> findAll(Pageable pageable) {
        return notificationRepo.findAll(pageable);
    }

    @Override
    public Iterable<Notification> findAll() {
        return notificationRepo.findAll();
    }

    @Override
    public Notification findById(Long id) {
        return notificationRepo.findById(id).get();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public Notification findNotiByPost(Long id) {
        return notificationRepo.findNotiByPost(id);
    }

    @Override
    public List<Notification> findNotiGroupByPost() {
        return notificationRepo.findNotiGroupByPost();
    }


    public List<Comment> findNotiByCmtOfMyPost(Long id) {
        User user = userService.findById(id);
        List<Post> posts = postService.findPostByUserId(user.getId());
        List<Comment> commentList = new ArrayList<>();
        for (Post p : posts) {
            Iterable<Comment> commentList1 = commentService.findAllCommentByPostId(p.getPostId());
            for (Comment c : commentList1) {
                if (p.getPostId().equals(c.getPostId()) && !(c.getUserId()).equals(p.getUserId())) {
                    commentList.add(c);
                }
            }
        }
        return commentList;
    }

    public List<Love> findNotiByLoveOfMyPost(Long id) {
        User user = userService.findById(id);
        List<Post> posts = postService.findPostByUserId(user.getId());
        List<Love> loveList = new ArrayList<>();
        for (Post p : posts) {
            List<Love> loveList1 = lovesv.findAllByPost(p);
            for (Love l : loveList1) {
                if (p.getPostId().equals(l.getPost().getPostId()) && !(l.getUser().getId().equals(p.getUserId()))) {
                    loveList.add(l);
                }
            }
        }
        return loveList;
    }

}
