package com.cognizant.service;

import com.cognizant.model.Post;
import com.cognizant.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return this.postRepository.findByOrderByIdDesc();
    }

    public Post getPostById(int id) {
        try {
            Post p = this.postRepository.getOne(id);
            System.out.println(p);
            return p;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
