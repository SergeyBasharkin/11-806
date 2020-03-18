package ru.kpfu.itis.demo.blog.impl.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.demo.blog.api.dto.CommentDTO;
import ru.kpfu.itis.demo.blog.api.service.CommentService;
import ru.kpfu.itis.demo.blog.impl.entity.Comment;
import ru.kpfu.itis.demo.blog.impl.jpa.CommentRepository;

@Service
public class CommentServiceDB implements CommentService {

    @Override
    public Page<CommentDTO> findAllByPostId(Long id, Pageable pageable) {
        return null;
    }
}
