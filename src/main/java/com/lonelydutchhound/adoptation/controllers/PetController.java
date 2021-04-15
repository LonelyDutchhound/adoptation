package com.lonelydutchhound.adoptation.controllers;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.PetSize;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    private @ResponseBody
    List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping(value="/pets/search")
    private @ResponseBody
    List<Pet> getByName(@RequestParam("name") String name){
        return petService.searchByName(name);
    }

    @PostMapping(
            value = "/pets",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    private @ResponseBody
    Pet savePet(
            @RequestParam String name,
            @RequestParam(required = false) String breed,
            @RequestParam UUID handlerId,
            @RequestParam Species species,
            @RequestParam(required = false) PetSize petSize
            ) {
        Pet.PetBuilder petBuilder = new Pet.PetBuilder()
                .setName(name)
                .setHandlerId(handlerId)
                .setSpecies(species);

        if (breed != null && !breed.isBlank()) petBuilder.setBreed(breed);
        if (petSize != null) petBuilder.setSize(petSize);

        Pet newPet = petBuilder.build();

        return petService.savePet(newPet);
    }
}
