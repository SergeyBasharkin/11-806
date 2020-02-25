package com.example.demo.command;

import com.example.demo.entity.TestEntity;
import com.example.demo.example.entity.Comment;
import com.example.demo.example.entity.Post;
import com.example.demo.example.jpa.PostRepository;
import com.example.demo.jpa.TestEntityRepository;
import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Fetch;
import java.util.List;


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

//        System.out.println();
//        System.out.println(repository.findByName("diam"));
//        System.out.println(repository.customFind());
//        System.out.println(repository.findQuery());
//        System.out.println(repository.findTestById(1L));
//
//        repository.findAll(
//                byId(1L).and(byName("name"))
//
//        );

//
//        postRepository.saveAll(Stream.of(dummyCreator.create(Post.class),
//                dummyCreator.create(Post.class),
//                dummyCreator.create(Post.class))
//                .peek(post -> {
//                    post.setId(null);
//                    post.setUser(null);
//                    post.getComments().forEach(comment -> {
//                        comment.setId(null);
//                        comment.setUser(null);
//                        comment.setPost(post);
//                    });
//                })
//                .collect(Collectors.toList())
//        );

//        List<Post> all = postRepository.findAll();
//        Page<Post> all = postRepository.findAll(Specification.where((root, query, criteriaBuilder) -> {
////            root.fetch("comments");
//            if (query.getResultType().equals(Long.class)) return null;
//            Fetch<Post, Comment> comments = root.fetch("comments");
//            comments.fetch("user");
////            comments.fetch("user");
//            return null;
//        }), PageRequest.of(0, 1));

        List<Post> all = postRepository.findAll();

        all.forEach(post -> {
            System.out.println(post.getId());
            post.getComments().forEach(comment -> System.out.println(comment.getId()));
        });
    }

    public static class SpecUtil {
        public static Specification<TestEntity> byId(Long id) {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
        }

        public static Specification<TestEntity> byName(String name) {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
        }
    }
}
