package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.repos.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) { return petRepository.saveAndFlush(pet); }

    public List<Pet> searchByName(String name) {
        List<Pet> pets = petRepository.searchByName(name);
        System.out.println(pets);
        return petRepository.searchByName(name);
    }
}
