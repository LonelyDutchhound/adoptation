package com.lonelydutchhound.adoptation.model;

import com.lonelydutchhound.adoptation.model.enums.SpeciesType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@ToString
@Table(name = "species")
@NoArgsConstructor
public class Species {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private SpeciesType species;

    public Species(UUID id, SpeciesType species) {
        this.id = id;
        this.species = species;
    }
}
