package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Data;

@Data
public class PostDTO {

    private Long id;
    private String title;
    private String body;

    private Long userId;
}
