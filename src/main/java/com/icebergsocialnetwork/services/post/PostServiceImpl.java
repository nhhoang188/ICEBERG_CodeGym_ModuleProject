package com.icebergsocialnetwork.services.post;

import com.icebergsocialnetwork.model.post.Post;
import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.repository.like.LoveRepository;
import com.icebergsocialnetwork.repository.post.PostRepo;
import com.icebergsocialnetwork.services.InterfaceService.IFriendReques;
import com.icebergsocialnetwork.services.InterfaceService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private LoveRepository loveRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IFriendReques friendReques;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepo.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> postOptional = postRepo.findById(id);
        return postOptional.orElse(null);
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Post> postOptional = postRepo.findById(id);
        if (!postOptional.isPresent()) {
            return;
        }
        loveRepository.deleteLoveByPostid(postOptional.get().getPostId());
        postRepo.deleteById(id);
    }

    @Override
    public Page<Post> findPostByUserIdOrderByCreateDateDesc(Long id, Pageable pageable) {
        return postRepo.findPostByUserIdOrderByCreateDateDesc(id, pageable);
    }

    @Override
    public Post findPostByPostId(Long postId) {
        return postRepo.findPostByPostId(postId);
    }

    @Override
    public List<Post> findPostByUserId(Long userId) {
        return postRepo.findPostByUserId(userId);
    }

    @Override
    public List<Post> findAllPostInTimeLine(Long id) {
        User user = userService.findById(id);
        List<Post> posts = postRepo.findAllByOrderByCreateDateDesc();
        List<Post> postList = new ArrayList<>();
        for (Post p : posts) {
            boolean checkfr = friendReques.checkFriendNative2(user.getId(), p.getUserId()) == null;
            if (checkfr && !(p.getPrivacy().equals("Private"))) {
                postList.add(p);
            }
        }
        return postList;
    }

}