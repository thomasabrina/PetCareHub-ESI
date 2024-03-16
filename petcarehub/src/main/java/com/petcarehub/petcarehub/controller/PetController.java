package com.petcarehub.petcarehub.controller;

import com.petcarehub.petcarehub.entities.Pet;
import com.petcarehub.petcarehub.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/get-all")
    public Iterable<Pet> getAllPets() {
        return petService.findAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return petService.findPetById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new-pet")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @PutMapping("/update-pet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet petDetails) {
        return petService.findPetById(id)
                .map(pet -> {
                    pet.setName(petDetails.getName());
                    pet.setBreed(petDetails.getBreed());
                    pet.setSex(petDetails.getSex());
                    pet.setAge(petDetails.getAge());
                    Pet updatedPet = petService.savePet(pet);
                    return ResponseEntity.ok(updatedPet);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        return petService.findPetById(id)
                .map(pet -> {
                    petService.deletePet(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

