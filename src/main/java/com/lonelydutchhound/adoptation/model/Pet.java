package com.lonelydutchhound.adoptation.model;

import com.lonelydutchhound.adoptation.model.enums.PetSize;
import com.lonelydutchhound.adoptation.model.enums.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@ToString
@Table(name = "pets")
@NoArgsConstructor
@TypeDef(
        name = "pet_size",
        typeClass = PostgreSQLEnumType.class
)
public class Pet {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String breed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "handlers_id", referencedColumnName = "id")
    @NotNull(message = "Handler is mandatory")
    private Profile handler;

    @Column
    private boolean adopted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    @NotNull(message = "Species is mandatory")
    private Species species;

    @Column
    @Enumerated(EnumType.STRING)
    @Type(type = "pet_size")
    private PetSize size;

    @Column(name = "created_at", insertable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private Pet(PetBuilder builder) {
        name = builder.name;
        breed = builder.breed;
        handler = builder.handler;
        adopted = builder.adopted;
        species = builder.species;
        size = builder.size;
    }

    @NoArgsConstructor
    public static class PetBuilder {

        private String name;
        private String breed;
        private Profile handler;
        private boolean adopted;
        private PetSize size;
        private Species species;

        public PetBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public PetBuilder setBreed(String breed) {
            this.breed = breed;

            return this;
        }

        public PetBuilder setHandler(Profile handler) {
            this.handler = handler;

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
