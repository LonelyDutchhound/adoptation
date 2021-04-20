package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Species;
import com.lonelydutchhound.adoptation.repos.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    public Species getSpeciesById(UUID id) {
        return speciesRepository.findById(id).orElseThrow();
    }
}
