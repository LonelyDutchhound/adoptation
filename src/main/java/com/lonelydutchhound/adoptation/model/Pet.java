package com.lonelydutchhound.adoptation.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@ToString
@Table(name = "pets")
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String breed;

    @Column(name = "handlers_id")
    private UUID handlerId;

    @Column
    private boolean adopted;

    @Column
    @Enumerated(EnumType.STRING)
    private Species species;

    @Column
    @Enumerated(EnumType.STRING)
    private PetSize size;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private Pet(PetBuilder builder) {
        name = builder.name;
        breed = builder.breed;
        handlerId = builder.handlerId;
        adopted = builder.adopted;
        species = builder.species;
        size = builder.size;
    }

    @NoArgsConstructor
    public static class PetBuilder {

        private String name;
        private String breed;
        private UUID handlerId;
        private boolean adopted;
        private Species species;
        private PetSize size;

        public PetBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public PetBuilder setBreed(String breed) {
            this.breed = breed;

            return this;
        }

        public PetBuilder setHandlerId(UUID handlerId) {
            this.handlerId = handlerId;

            return this;
        }

        public PetBuilder setAdopted(boolean adopted) {
            this.adopted = adopted;

            return this;
        }

        public PetBuilder setSpecies(Species species) {
            this.species = species;

            return this;
        }

        public PetBuilder setSize(PetSize size) {
            this.size = size;

            return this;
        }


        public Pet build() {
            return new Pet(this);
        }

    }
}
