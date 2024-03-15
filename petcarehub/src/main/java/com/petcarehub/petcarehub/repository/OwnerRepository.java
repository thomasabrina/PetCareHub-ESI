package com.petcarehub.petcarehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcarehub.petcarehub.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
