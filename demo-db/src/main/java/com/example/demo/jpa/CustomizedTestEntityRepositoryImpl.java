package com.example.demo.jpa;

import com.example.demo.entity.TestEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CustomizedTestEntityRepositoryImpl implements CustomizedTestEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TestEntity> customFind() {
        return entityManager.createNativeQuery("select * from TEST_ENTITY", TestEntity.class).getResultList();
    }
}
