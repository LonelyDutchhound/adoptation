package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.repos.PetRepository;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private SpeciesService speciesService;

    public Pet buildPetFromRequest(PetRequest request) {
        UUID handlerId = request.getHandlerId();
        UUID speciesId = request.getSpeciesId();

        // or throw? need to proceed the situation properly
        if (handlerId == null || speciesId == null) return null;

        Profile handler = profileService.getProfileById(handlerId);
        Species species = speciesService.getSpeciesById(speciesId);

        return new Pet.PetBuilder()
                .setName(request.getName())
                .setHandler(handler)
                .setSpecies(species)
                .setBreed(request.getBreed())
                .setSize(request.getPetSize())
                .build();
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        return petRepository.saveAndFlush(pet);
    }

    public List<Pet> findByName(String name) {
        List<Pet> pets = petRepository.findByName(name);

        return petRepository.findByName(name);
    }
}
