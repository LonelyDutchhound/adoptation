package com.lonelydutchhound.adoptation.repository;

import com.lonelydutchhound.adoptation.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends CrudRepository<Pet, UUID> {
}
