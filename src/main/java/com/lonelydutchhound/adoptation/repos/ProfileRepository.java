package com.lonelydutchhound.adoptation.repos;

import com.lonelydutchhound.adoptation.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
}
