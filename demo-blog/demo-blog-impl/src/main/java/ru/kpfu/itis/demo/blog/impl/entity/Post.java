package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
public class Post extends AutoincrementEntity {

    private String title;
    private String body;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
