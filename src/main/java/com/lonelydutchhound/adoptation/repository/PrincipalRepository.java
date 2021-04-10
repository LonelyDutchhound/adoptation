package com.lonelydutchhound.adoptation.repository;

import com.lonelydutchhound.adoptation.model.Principal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrincipalRepository extends JpaRepository<Principal, UUID> {

    Optional<Principal> findPrincipalByUsername(String username);
}
