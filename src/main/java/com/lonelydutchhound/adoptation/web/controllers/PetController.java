package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.model.User;
import com.lonelydutchhound.adoptation.model.enums.PetSize;
import com.lonelydutchhound.adoptation.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.lonelydutchhound.adoptation.web.responses.PetResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    private @ResponseBody
    List<PetResponse> getAllPets(){
        List<PetResponse> response = new LinkedList<>();
        List<Pet> allPets = petService.getAllPets();

        allPets.forEach(pet -> response.add(new PetResponse(
            pet.getId(),
            pet.getName(),
            pet.getBreed(),
            new User(
                    pet.getHandlerId(),
                    pet.getHandlerFirstName(),
                    pet.getHandlerLastName(),
                    pet.getPhone(),
                    pet.getEmail()
            ),
            new Species(
                    pet.getSpeciesId(),
                    pet.getSpecies()
            ),
            pet.isAdopted(),
            pet.getSize(),
            pet.getCreatedAt()
        )));

        return response;
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
            @RequestParam UUID speciesId,
            @RequestParam(required = false) PetSize petSize
            ) {
        Pet.PetBuilder petBuilder = new Pet.PetBuilder()
                .setName(name)
                .setHandlerId(handlerId)
                .setSpeciesId(speciesId);

        if (breed != null && !breed.isBlank()) petBuilder.setBreed(breed);
        if (petSize != null) petBuilder.setSize(petSize);

        Pet newPet = petBuilder.build();

        return petService.savePet(newPet);
    }
}
