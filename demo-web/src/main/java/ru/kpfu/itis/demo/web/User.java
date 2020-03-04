package ru.kpfu.itis.demo.web;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
public class User {
    @Id
    private Long id;

    private String username;

    private String pass;
}
