package com.lonelydutchhound.adoptation.services.DTOmappers;

import com.lonelydutchhound.adoptation.DTO.CommonProfileDTO;
import com.lonelydutchhound.adoptation.DTO.PetDTO;
import com.lonelydutchhound.adoptation.DTO.SpeciesDTO;
import com.lonelydutchhound.adoptation.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetMapService {
    @Autowired
    ProfileMapService profileMapService;

    public PetDTO convertToPetDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());

        CommonProfileDTO handlerProfileDTO = profileMapService
                .convertToCommonProfileDTO(pet.getHandler());
        petDTO.setHandlerProfile(handlerProfileDTO);

        SpeciesDTO speciesDTO = new SpeciesDTO.SpeciesBuilder()
                .setId(pet.getSpecies().getId())
                .setSpecies(pet.getSpecies().getSpecies())
                .build();
        petDTO.setSpecies(speciesDTO);
        petDTO.setBreed(pet.getBreed());
        petDTO.setSize(pet.getSize());
        return petDTO;
    }
}
