package com.example.demo.jpa;

import com.example.demo.entity.TestEntity;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long>, CustomizedTestEntityRepository, JpaSpecificationExecutor<TestEntity> {
    Page<TestEntity> findByName(String name, Pageable pageable);

    @Query(value = "select * from TEST_ENTITY ", nativeQuery = true)
    List<TestEntity> findQuery();

    OnlyName findTestById(Long id);
}
