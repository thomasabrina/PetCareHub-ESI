package com.petcarehub.petcarehub.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.NavigableMap;

@Data
@Entity
@Table(name = "pet")
public class Pet {
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;
    @Column(name = "breed", nullable = false)
    private String breed;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "sex", nullable = false)
    private String sex;
    // Define Entity Relationship
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}

