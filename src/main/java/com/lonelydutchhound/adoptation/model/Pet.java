package com.lonelydutchhound.adoptation.model;

import com.lonelydutchhound.adoptation.constants.PetSize;
import com.lonelydutchhound.adoptation.constants.Species;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue
    @Getter @Setter
    private UUID id;

    @Column
    @Getter @Setter
    @NonNull private String name;

    @Column
    @Getter @Setter
    private String breed;

    @Column(name = "handlers_id")
    @Getter @Setter
    private UUID handlerId;

    @Column
    @Getter @Setter
    private boolean adopted;

    @Column
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @NonNull private Species species;

    @Column
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @NonNull private PetSize size;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @Getter @Setter
    private Date createdAt;

    public Pet(@NonNull String name, UUID handlerId, @NonNull Species species) {
        this.name = name;
        this.handlerId = handlerId;
        this.species = species;
    }

    public Pet(@NonNull String name, String breed, UUID handlerId, @NonNull Species species) {
        this.name = name;
        this.breed = breed;
        this.handlerId = handlerId;
        this.species = species;
    }

    public Pet(@NonNull String name, UUID handlerId, @NonNull Species species, @NonNull PetSize size) {
        this.name = name;
        this.handlerId = handlerId;
        this.species = species;
        this.size = size;
    }

    public Pet(@NonNull String name, String breed, UUID handlerId, @NonNull Species species, @NonNull PetSize size) {
        this.name = name;
        this.breed = breed;
        this.handlerId = handlerId;
        this.species = species;
        this.size = size;
    }
}
