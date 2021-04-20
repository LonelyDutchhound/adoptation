package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Validated
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profiles")
    List<Profile> getAllProfiles() {
        return profileService.findAll();
    }

    @GetMapping("/profiles/{id}")
    Profile getProfileById(@PathVariable UUID id)  {
            return profileService.getProfileById(id);
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> createProfile(@Valid @RequestBody Profile request, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            Profile profile = profileService.saveProfile(request);

            return ResponseEntity
                    .created(URI.create("/profiles/" + profile.getId()))
                    .body(profile);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Request contains incorrect data = [%s]", getErrors(bindingResult)));
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        if (profileService.existProfileById(id)) {
            profileService.deleteProfileById(id);

            return ResponseEntity.status(NO_CONTENT).build();
        } else
            return ResponseEntity.notFound().build();
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
