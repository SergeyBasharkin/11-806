package ru.kpfu.itis.demo.blog.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;

@RestController("/post/{id}/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void save(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        commentDTO.setPostId(id);
        commentService.save(commentDTO);
    }

    @GetMapping
    public Page<CommentDTO> findAll(@PathVariable Long id, Pageable pageable) {
        return commentService.findAllByPostId(id, pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
