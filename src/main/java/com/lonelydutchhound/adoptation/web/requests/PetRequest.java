package com.lonelydutchhound.adoptation.web.requests;

import com.lonelydutchhound.adoptation.model.enums.PetSize;
import lombok.Value;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Value
public class PetRequest {
    String name;
    String breed;
    UUID handlerId;
    UUID speciesId;
    PetSize petSize;
}
