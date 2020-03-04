package com.example.demo.command;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.entity.TestEntity;
import com.example.demo.jpa.PostRepository;
import com.example.demo.jpa.TestEntityRepository;
import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Fetch;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.command.RunCommand.SpecUtil.byId;
import static com.example.demo.command.RunCommand.SpecUtil.byName;


@Component
public class RunCommand implements CommandLineRunner {

    @Autowired
    private TestEntityRepository repository;
    @Autowired
    private PostRepository postRepository;

    private DummyCreator dummyCreator = new DummyCreator(ClassBindings.defaultBindings());

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        TestEntity testEntity = new DummyCreator(ClassBindings.defaultBindings()).create(TestEntity.class);
//        testEntity.setId(null);
//        repository.save(testEntity);

//        repository.findById(1L).ifPresent(testEntity1 -> {
//            System.out.println(testEntity1.getName());
//        });

        System.out.println();
//        System.out.println(repository.findByName("diam"));
//        System.out.println(repository.customFind());
//        System.out.println(repository.findQuery());
//        System.out.println(repository.findTestById(1L));
//        TestEntity entity = new TestEntity();
//        entity.setId(1L);

//        System.out.println(repository.findAll(Example.of(entity)));

//        repository.findAll(
//                byId(1L).and(byName("name"))
//
//        );

//        postRepository.saveAll(Stream.of(
//                dummyCreator.create(Post.class),
//                dummyCreator.create(Post.class),
//                dummyCreator.create(Post.class)
//        ).peek(post -> {
//            post.setId(null);
//            post.getComments().forEach(comment -> {
//                comment.setId(null);
//                comment.setPost(post);
//            });
//        }).collect(Collectors.toList()));

        postRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
//            if (!criteriaQuery.getResultType().equals(Long.class))
            Fetch<Post, Comment> comments = root.fetch("comments");
            comments.fetch("user");
            return null;
        }).forEach(post -> {
            System.out.println(post.getId());
            post.getComments().forEach(comment -> {
                System.out.println(comment.getId());
                System.out.println(comment.getUser().getUsername());
            });
        });
    }

    public static class SpecUtil{
        public static Specification<TestEntity> byId(Long id){
            return (root, criteriaQuery, criteriaBuilder) ->criteriaBuilder.equal(root.get("id"), id);
        }

        public static Specification<TestEntity> byName(String name){
            return (root, criteriaQuery, criteriaBuilder) ->criteriaBuilder.equal(root.get("name"), name);
        }
    }
}
