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
        return (List<Pet>) petRepository.findAll();
    }
}
