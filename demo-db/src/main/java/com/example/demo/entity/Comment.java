package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Comment extends AbstractEntity {

    private String body;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
