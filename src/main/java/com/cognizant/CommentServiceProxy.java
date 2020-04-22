package com.cognizant;

import com.cognizant.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "comment-service", url = "localhost:8101")
public interface CommentServiceProxy {

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getCommentsByPost(@PathVariable("postId") int postId);
}
