package ru.kpfu.itis.demo.blog.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.PostDTO;
import ru.kpfu.itis.demo.blog.api.service.PostService;

@RestController("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void save(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
    }

    @GetMapping
    public Page<PostDTO> findAll(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
