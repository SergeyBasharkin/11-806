package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table
@Entity
//@NamedEntityGraph(
//        name = "Post.Comment",
//        attributeNodes =
//        @NamedAttributeNode(
//                value = "comments",
//                subgraph = "Comment.User"
//        ),
//        subgraphs =
//        @NamedSubgraph(
//                name = "Comment.User",
//                attributeNodes = @NamedAttributeNode("user")))
public class Post extends AbstractEntity {

    private String title;
    private String body;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

}
