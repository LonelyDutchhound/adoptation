package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    List<Profile> getAllProfiles() {
        return profileService.findAll();
    }

    @GetMapping("/profiles/{id}")
    ResponseEntity<Profile> getProfileById(@PathVariable UUID id)  {
        try {
            Profile profile = profileService.getProfileById(id);

            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
