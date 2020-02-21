package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import com.example.demo.jpa.TestEntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final TestEntityRepository repository;

    public TestController(TestEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Page<TestEntity> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }
}
