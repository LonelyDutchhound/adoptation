package com.lonelydutchhound.adoptation.repos;

import com.lonelydutchhound.adoptation.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, UUID> {
}
