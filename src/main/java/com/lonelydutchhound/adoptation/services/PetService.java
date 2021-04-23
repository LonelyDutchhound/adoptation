package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.DTO.CommonProfileDTO;
import com.lonelydutchhound.adoptation.DTO.PetDTO;
import com.lonelydutchhound.adoptation.DTO.SpeciesDTO;
import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.repos.PetRepository;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
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
        Profile handler;
        Species species;

        if (handlerId == null || speciesId == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        try {
            handler = profileService.getProfileById(handlerId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Handler not found", e);
        }

        try {
            species = speciesService.getSpeciesById(speciesId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Species not found", e);
        }

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
