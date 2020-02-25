package com.example.demo.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class User extends AutoIncrement {

    private String username;
    private String pswd;
}
