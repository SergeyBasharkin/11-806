package com.example.demo.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

//@NamedEntityGraph(name = "Post.Comments", attributeNodes = {
//        @NamedAttributeNode(value = "comments", subgraph = "Comments.User")
//}, subgraphs = @NamedSubgraph(name = "Comments.User", attributeNodes = {@NamedAttributeNode("user")}))
@EqualsAndHashCode(callSuper = true, exclude = "comments")
@ToString(exclude = "comments")
@Entity
@Table
@Data
public class Post extends AutoIncrement {

    private String title;
    private String body;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
