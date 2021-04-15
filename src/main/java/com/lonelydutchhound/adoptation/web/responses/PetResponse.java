package com.lonelydutchhound.adoptation.web.responses;

import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.model.User;
import com.lonelydutchhound.adoptation.model.enums.PetSize;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
public class PetResponse {
    UUID id;
    String name;
    String breed;
    User petHandler;
    Species petSpecies;
    boolean adopted;
    PetSize size;
    Date createdAt;
}
