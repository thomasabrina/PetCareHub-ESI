package com.petcarehub.petcarehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.Collections;
import java.util.Set;

import com.petcarehub.petcarehub.entities.Owner;
import com.petcarehub.petcarehub.entities.Pet;
import com.petcarehub.petcarehub.repository.OwnerRepository;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner saveOwner(Owner owner) {
        return (Owner) ownerRepository.save(owner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    public Set<Pet> findPetsByOwnerId(Long ownerId) {
        Optional<Owner> owner = findOwnerById(ownerId);
        return owner.map(Owner::getPets).orElse(Collections.emptySet());
    }
}
