package com.cognizant.controller;

import com.cognizant.CommentServiceProxy;
import com.cognizant.model.Comment;
import com.cognizant.model.Post;
import com.cognizant.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentServiceProxy proxy;

    @GetMapping
    public List<Post> getAllPosts() {
        List<Post> posts = this.postService.getAllPosts();
        for (Post post: posts) {
            post.setNumberOfComments(this.proxy.getNumberOfCommentsByPost(post.getId()));
        }
        return posts;
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        Post post = this.postService.getPostById(postId);
        if (post == null) {
            return null;
        }
        post.setNumberOfComments(this.proxy.getNumberOfCommentsByPost(post.getId()));
        List<Comment> comments = this.proxy.getCommentsByPost(postId, 0);
        post.setComments(comments);
        return post;
    }
}
