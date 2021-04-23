package com.lonelydutchhound.adoptation.DTO;

import com.lonelydutchhound.adoptation.model.enums.PetSize;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PetDTO {
    private UUID id;
    private String name;
    private String breed;
    private CommonProfileDTO handlerProfile;
    private boolean adopted;
    private SpeciesDTO species;
    private PetSize size;
}
