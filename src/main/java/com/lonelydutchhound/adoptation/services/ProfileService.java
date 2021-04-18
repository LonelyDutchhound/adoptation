package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(UUID id){
        return profileRepository.findById(id).orElseThrow();
    }

    public Profile findProfileById(UUID id) { return profileRepository.getOne(id); }
}
