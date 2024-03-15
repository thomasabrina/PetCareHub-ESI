package com.petcarehub.petcarehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcarehub.petcarehub.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
