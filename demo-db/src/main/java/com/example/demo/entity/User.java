package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Data
public class User extends AbstractEntity {
    private String username;
    private String pswd;
}
