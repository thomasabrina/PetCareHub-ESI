package com.petcarehub.petcarehub.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "pets")
@ToString(exclude = "pets")
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "owner")
public class Owner {
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "e_mail", nullable = true)
    private String email;
    @Column(name = "address", nullable = true)
    private String address;
    // Define Entity Relationship
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}

