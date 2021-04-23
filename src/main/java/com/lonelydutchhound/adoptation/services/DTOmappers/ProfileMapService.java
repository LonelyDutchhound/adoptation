package com.lonelydutchhound.adoptation.services.DTOmappers;

import com.lonelydutchhound.adoptation.DTO.CommonProfileDTO;
import com.lonelydutchhound.adoptation.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileMapService {
    public CommonProfileDTO convertToCommonProfileDTO(Profile profile) {
        CommonProfileDTO profileDTO = new CommonProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setFullName(profile.getFirstName(), profile.getLastName());
        profileDTO.setPhoneNumber(profile.getPhoneNumber());
        profileDTO.setEmail(profile.getEmail());
        return profileDTO;
    }
}
