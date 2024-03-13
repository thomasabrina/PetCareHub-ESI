package com.petcarehub.petcarehub.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.NavigableMap;

@Data
@Entity
@Table(name = "pet")
public class Pet {
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @GeneratedValue
    private String petId;
    @Column(name = "breed", nullable = false)
    private String breed;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "sex", nullable = false)
    private Integer sex;
}
