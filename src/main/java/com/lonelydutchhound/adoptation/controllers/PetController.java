package com.lonelydutchhound.adoptation.controllers;

import com.lonelydutchhound.adoptation.model.Pet;
import com.lonelydutchhound.adoptation.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    private @ResponseBody
    List<Pet> getAllPets(){
        return petService.getAllPets();
    }
}
