package com.lonelydutchhound.adoptation.model;

import com.lonelydutchhound.adoptation.model.enums.PetSize;
import com.lonelydutchhound.adoptation.model.enums.SpeciesType;
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

    @Column(name="first_name")
    String handlerFirstName;

    @Column(name="last_name")
    String handlerLastName;

    @Column
    String email;

    @Column
    String phone;

    @Column
    private boolean adopted;

    @Column
    @Enumerated(EnumType.STRING)
    private SpeciesType species;

    @Column(name="species_id")
    private UUID speciesId;

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
        speciesId = builder.speciesId;
        size = builder.size;
    }

    @NoArgsConstructor
    public static class PetBuilder {

        private String name;
        private String breed;
        private UUID handlerId;
        private boolean adopted;
        private PetSize size;
        private UUID speciesId;

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

        public PetBuilder setSpeciesId(UUID speciesId) {
            this.speciesId = speciesId;

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
