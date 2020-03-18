package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String body;
    private Long postId;
    private Long userId;
}
