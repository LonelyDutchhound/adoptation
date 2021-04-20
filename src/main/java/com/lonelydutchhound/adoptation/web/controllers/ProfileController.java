package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Profile createProfile(@RequestBody @Valid Profile request){
            return profileService.saveProfile(request);
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
