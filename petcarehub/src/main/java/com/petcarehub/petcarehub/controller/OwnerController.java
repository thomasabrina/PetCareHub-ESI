package com.petcarehub.petcarehub.controller;

import com.petcarehub.petcarehub.entities.Owner;
import com.petcarehub.petcarehub.entities.Pet;
import com.petcarehub.petcarehub.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/get-all")
    public List<Owner> getAllOwners() {
        return ownerService.findAllOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return ownerService.findOwnerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<Set<Pet>> getPetsByOwnerId(@PathVariable Long id) {
        Set<Pet> pets = ownerService.findPetsByOwnerId(id);
        if (pets.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/new-owner")
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @PutMapping("/update-owner/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        return ownerService.findOwnerById(id)
                .map(owner -> {
                    if (ownerDetails.getName() != null) {
                        owner.setName(ownerDetails.getName());
                    }
                    if (ownerDetails.getEmail() != null) {
                        owner.setEmail(ownerDetails.getEmail());
                    }
                    if (ownerDetails.getAddress() != null) {
                        owner.setAddress(ownerDetails.getAddress());
                    }
                    Owner updatedOwner = ownerService.saveOwner(owner);
                    return ResponseEntity.ok(updatedOwner);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        return ownerService.findOwnerById(id)
                .map(owner -> {
                    ownerService.deleteOwner(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

