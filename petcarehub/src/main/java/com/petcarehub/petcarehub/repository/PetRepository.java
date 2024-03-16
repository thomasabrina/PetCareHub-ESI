package com.petcarehub.petcarehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcarehub.petcarehub.entities.Pet;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
