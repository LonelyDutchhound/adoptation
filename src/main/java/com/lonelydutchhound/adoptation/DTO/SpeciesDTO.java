package com.lonelydutchhound.adoptation.DTO;

import com.lonelydutchhound.adoptation.model.enums.SpeciesType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class SpeciesDTO {
    private UUID id;
    private SpeciesType species;

    private SpeciesDTO(SpeciesBuilder builder) {
        id = builder.getId();
        species = builder.getSpecies();
    }


    public static class SpeciesBuilder {
        private UUID id;
        private SpeciesType species;

        public UUID getId() {
            return id;
        }

        public SpeciesBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public SpeciesType getSpecies() {
            return species;
        }

        public SpeciesBuilder setSpecies(SpeciesType species) {
            this.species = species;
            return this;
        }

        public SpeciesDTO build() {
            return new SpeciesDTO(this);
        }
    }
}
