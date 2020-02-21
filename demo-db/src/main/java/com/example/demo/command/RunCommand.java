package com.example.demo.command;

import com.example.demo.entity.TestEntity;
import com.example.demo.jpa.TestEntityRepository;
import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static com.example.demo.command.RunCommand.SpecUtil.byId;
import static com.example.demo.command.RunCommand.SpecUtil.byName;


@Component
public class RunCommand implements CommandLineRunner {

    @Autowired
    private TestEntityRepository repository;

    @Override
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
        System.out.println(repository.findTestById(1L));

        repository.findAll(
                byId(1L).and(byName("name"))
                
        );
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
