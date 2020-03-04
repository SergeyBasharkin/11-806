package com.example.demo.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class AutoIncrement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
