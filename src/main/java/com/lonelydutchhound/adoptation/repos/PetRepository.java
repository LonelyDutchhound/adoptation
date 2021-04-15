package com.lonelydutchhound.adoptation.repos;

import com.lonelydutchhound.adoptation.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {

    @Query(value = "SELECT * FROM pets p JOIN species s ON p.species_id = s.id WHERE p.name iLIKE %:name%", nativeQuery = true)
    List<Pet> searchByName(@Param("name") String name);
}
