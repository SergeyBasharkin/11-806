package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "test_entity")
@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
