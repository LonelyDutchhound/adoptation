package com.lonelydutchhound.adoptation.web.services;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.services.ProfileService;
import com.lonelydutchhound.adoptation.web.responses.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetResponseService implements ResponseService<PetResponse, Pet> {
    @Autowired
    private ProfileService profileService;

    public PetResponse getResponseBody(Pet pet) {
        PetResponse.PetResponseBuilder responseBuilder = new PetResponse.PetResponseBuilder();
        Profile.ProfileBuilder profileBuilder = new Profile.ProfileBuilder();
        Profile handler = profileService.getProfileById(pet.getHandlerId());

        return responseBuilder
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
    }
}
