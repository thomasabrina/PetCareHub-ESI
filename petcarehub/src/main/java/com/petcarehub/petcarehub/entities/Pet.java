package com.petcarehub.petcarehub.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "owner")
@ToString(exclude = "owner")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "petId")
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

