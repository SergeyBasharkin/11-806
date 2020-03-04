package com.example.demo.example.jpa;

import com.example.demo.example.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    @Override
//    @EntityGraph(value = "Post.Comments")
    List<Post> findAll();
}
