package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
public class Comment extends AutoincrementEntity {

    private String body;

    private Long userId;
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
