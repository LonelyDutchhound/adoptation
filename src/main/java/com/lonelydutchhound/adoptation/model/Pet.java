package com.lonelydutchhound.adoptation.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Species species;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSize size;

    @Column(name = "breed")
    private String breed;

    @Column(name = "handler_id")
    private UUID handlerId;

}
