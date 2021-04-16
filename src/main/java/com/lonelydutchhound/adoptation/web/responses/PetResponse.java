package com.lonelydutchhound.adoptation.web.responses;

import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.model.enums.PetSize;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
public class PetResponse {
    UUID id;
    String name;
    String breed;
    Profile petHandler;
    Species petSpecies;
    boolean adopted;
    PetSize size;
    Date createdAt;

    public PetResponse(PetResponseBuilder builder) {
        id = builder.id;
        name = builder.name;
        breed = builder.breed;
        petHandler = builder.petHandler;
        petSpecies = builder.petSpecies;
        adopted = builder.adopted;
        size = builder.size;
        createdAt = builder.createdAt;
    }

    public static class PetResponseBuilder {
        UUID id;
        String name;
        String breed;
        Profile petHandler;
        Species petSpecies;
        boolean adopted;
        PetSize size;
        Date createdAt;

        public PetResponseBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public PetResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetResponseBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public PetResponseBuilder setPetHandler(Profile petHandler) {
            this.petHandler = petHandler;
            return this;
        }

        public PetResponseBuilder setPetSpecies(Species petSpecies) {
            this.petSpecies = petSpecies;
            return this;
        }

        public PetResponseBuilder setAdopted(boolean adopted) {
            this.adopted = adopted;
            return this;
        }

        public PetResponseBuilder setSize(PetSize size) {
            this.size = size;
            return this;
        }

        public PetResponseBuilder setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PetResponse build() {
            return new PetResponse(this);
        }
    }
}
