package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.services.PetService;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping(value = "/pets/search")
    List<Pet> getByName(@RequestParam("name") String name) {
        return petService.findByName(name);
    }

    @PostMapping(
            value = "/pets",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    Pet createPet(@RequestBody PetRequest request) {
        Pet pet = petService.buildPetFromRequest(request);
        return petService.savePet(pet);
    }
}
