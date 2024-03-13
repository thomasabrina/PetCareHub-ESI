package com.petcarehub.petcarehub.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "owner")
public class Owner {
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @GeneratedValue
    private String id;
    @Column(name = "e_mail", nullable = true)
    private String email;
    @Column(name = "address", nullable = true)
    private String address;
}
