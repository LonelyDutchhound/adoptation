package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Profile;
import com.lonelydutchhound.adoptation.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile getProfileById(UUID id){
        return profileRepository.findById(id).get();
    }
}
