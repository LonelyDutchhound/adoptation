package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(UUID id) {
        return profileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public boolean existProfileById(UUID id) {
        return profileRepository.existsById(id);
    }

    public Profile findProfileById(UUID id) {
        return profileRepository.getOne(id);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfileById(UUID id) {
        profileRepository.deleteById(id);
    }
}
