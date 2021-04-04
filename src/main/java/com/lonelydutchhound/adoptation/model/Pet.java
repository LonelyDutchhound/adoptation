package com.lonelydutchhound.adoptation.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String breed;

    @Column(name = "handlers_id")
    private UUID handlerId;

    @Column
    private boolean adopted;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Species species;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSize size;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;


    private Pet() {
    }

    public class PetBuilder {

        public PetBuilder() {
        }

        public PetBuilder setName(String name) {
            Pet.this.name = name;

            return this;
        }

        public PetBuilder setBreed(String breed) {
            Pet.this.breed = breed;

            return this;
        }

        public PetBuilder setHandlerId(UUID handlerId) {
            Pet.this.handlerId = handlerId;

            return this;
        }

        public PetBuilder setAdopted(boolean adopted) {
            Pet.this.adopted = adopted;

            return this;
        }

        public PetBuilder setSpecies(Species species) {
            Pet.this.species = species;

            return this;
        }

        public PetBuilder setSize(PetSize size) {
            Pet.this.size = size;

            return this;
        }

        public PetBuilder setCreatedAt(Date createdAt) {
            Pet.this.createdAt = createdAt;

            return this;
        }

        public PetBuilder buid() {
            return this;
        }


    }
}
