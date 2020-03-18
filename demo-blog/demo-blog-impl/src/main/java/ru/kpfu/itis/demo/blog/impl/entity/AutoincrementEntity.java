package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AutoincrementEntity {

    @Id
    @GeneratedValue
    private Long id;
}
