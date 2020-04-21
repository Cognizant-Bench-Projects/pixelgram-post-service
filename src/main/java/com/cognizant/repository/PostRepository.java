package com.cognizant.repository;

import com.cognizant.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByOrderByIdDesc();
}
