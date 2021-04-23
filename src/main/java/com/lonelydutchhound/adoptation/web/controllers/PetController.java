package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.DTO.PetDTO;
import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.services.DTOmappers.PetMapService;
import com.lonelydutchhound.adoptation.services.PetService;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private PetMapService petMapService;

    @GetMapping("/pets")
    List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping(value="/pets/search")
    List<Pet> getByName(@RequestParam("name") String name){
        return petService.findByName(name);
    }

    @PostMapping(
            value = "/pets",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<PetDTO> createPet(@RequestBody PetRequest request) {
        Pet pet = petService.buildPetFromRequest(request);

        return ResponseEntity
                .created(URI.create("/pets/" + pet.getId()))
                .body(petMapService
                        .convertToPetDTO(petService.
                                savePet(pet)
                        ));
    }
}
