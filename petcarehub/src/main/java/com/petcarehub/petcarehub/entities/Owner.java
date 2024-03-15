package com.petcarehub.petcarehub.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
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
