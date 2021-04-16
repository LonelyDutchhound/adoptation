package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.services.PetService;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import com.lonelydutchhound.adoptation.web.services.PetResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.lonelydutchhound.adoptation.web.responses.PetResponse;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private PetResponseService petResponseService;

    @GetMapping("/pets")
    private @ResponseBody
    List<PetResponse> getAllPets(){
        List<PetResponse> response = new LinkedList<>();
        List<Pet> allPets = petService.getAllPets();

        allPets.forEach(pet -> {
            PetResponse petResponse = petResponseService.getResponseBody(pet);
            response.add(petResponse);
        });

        return response;
    }

    @GetMapping(value="/pets/search")
    private @ResponseBody
    List<PetResponse> getByName(@RequestParam("name") String name){
        List<PetResponse> response = new LinkedList<>();
        List<Pet> allPets = petService.searchByName(name);

        allPets.forEach(pet -> {
            PetResponse petResponse = petResponseService.getResponseBody(pet);
            response.add(petResponse);
        });

        return response;
    }

    @PostMapping(
            value = "/pets",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    private @ResponseBody
    PetResponse savePet(@RequestBody PetRequest request) {
        Pet pet = petService.buildPetFromRequest(request);
        PetResponse response = petResponseService.getResponseBody(petService.savePet(pet));

        return response;
    }
}
