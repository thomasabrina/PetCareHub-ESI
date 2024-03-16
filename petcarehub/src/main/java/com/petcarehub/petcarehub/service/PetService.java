package com.petcarehub.petcarehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.petcarehub.petcarehub.entities.Pet;
import com.petcarehub.petcarehub.repository.PetRepository;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public Iterable<Pet> findAllPets() {
        return petRepository.findAll();
    }
}
