package com.cognizant;

import com.cognizant.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-gateway", url = "localhost:8765/comment-service")
public interface CommentServiceProxy {

    @GetMapping("/posts/{postId}/comments/page/{pageNum}")
    public List<Comment> getCommentsByPost(@PathVariable("postId") int postId, @PathVariable("pageNum") int pageNum);

    @GetMapping("/posts/{postId}/comments/number-of-comments")
    public int getNumberOfCommentsByPost(@PathVariable("postId") int postId);
}
