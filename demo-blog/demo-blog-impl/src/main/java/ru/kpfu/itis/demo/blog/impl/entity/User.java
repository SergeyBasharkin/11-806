package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends AutoincrementEntity {

    private String username;
    private String password;
    private String email;
}
