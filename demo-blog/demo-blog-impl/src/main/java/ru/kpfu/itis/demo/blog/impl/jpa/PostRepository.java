package ru.kpfu.itis.demo.blog.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.demo.blog.impl.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
