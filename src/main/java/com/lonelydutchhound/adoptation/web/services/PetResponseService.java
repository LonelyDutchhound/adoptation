package com.lonelydutchhound.adoptation.web.services;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.model.User;
import com.lonelydutchhound.adoptation.services.UserService;
import com.lonelydutchhound.adoptation.web.responses.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetResponseService implements ResponseService<PetResponse, Pet> {
    @Autowired
    private UserService userService;

    public PetResponse getResponseBody(Pet pet) {
        PetResponse.PetResponseBuilder responseBuilder = new PetResponse.PetResponseBuilder();
        User.UserBuilder userBuilder = new User.UserBuilder();
        User handler = userService.getUserById(pet.getHandlerId());

//        User handler = userBuilder
//                .setId(pet.getHandlerId())
//                .setFirstName(pet.getHandlerFirstName())
//                .setEmail(pet.getEmail())
//                .setLastName(pet.getHandlerLastName())
//                .setPhoneNumber(pet.getPhone())
//                .build();

        PetResponse petResponse = responseBuilder
                .setId(pet.getId())
                .setName(pet.getName())
                .setBreed(pet.getBreed())
                .setPetHandler(handler)
                .setPetSpecies(new Species(
                        pet.getSpeciesId(),
                        pet.getSpecies()
                ))
                .setAdopted(pet.isAdopted())
                .setSize(pet.getSize())
                .setCreatedAt(pet.getCreatedAt())
                .build();

        return petResponse;
    }
}
