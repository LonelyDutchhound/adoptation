package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.model.enums.PetSize;
import com.lonelydutchhound.adoptation.repos.PetRepository;
import com.lonelydutchhound.adoptation.web.requests.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet buildPetFromRequest(PetRequest request){
        Pet.PetBuilder petBuilder = new Pet.PetBuilder()
                .setName(request.getName())
                .setHandlerId(request.getHandlerId())
                .setSpeciesId(request.getSpeciesId());

        String breed = request.getBreed();
        if (breed != null && !breed.isBlank()) petBuilder.setBreed(breed);

        PetSize size = request.getPetSize();
        if (size != null) petBuilder.setSize(size);

        return petBuilder.build();
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        return petRepository.saveAndFlush(pet);
    }

    public List<Pet> searchByName(String name) {
        List<Pet> pets = petRepository.searchByName(name);

        return petRepository.searchByName(name);
    }
}
