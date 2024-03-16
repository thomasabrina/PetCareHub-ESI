package com.petcarehub.petcarehub.controller;

import com.petcarehub.petcarehub.entities.Owner;
import com.petcarehub.petcarehub.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.findAllOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return ownerService.findOwnerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        return ownerService.findOwnerById(id)
                .map(owner -> {
                    owner.setName(ownerDetails.getName());
                    owner.setEmail(ownerDetails.getEmail());
                    owner.setAddress(ownerDetails.getAddress());
                    Owner updatedOwner = ownerService.saveOwner(owner);
                    return ResponseEntity.ok(updatedOwner);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        return ownerService.findOwnerById(id)
                .map(owner -> {
                    ownerService.deleteOwner(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

