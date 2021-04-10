package com.lonelydutchhound.adoptation.repository;

import com.lonelydutchhound.adoptation.model.PrincipalRole;
import com.lonelydutchhound.adoptation.model.PrincipalRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PrincipalRoleRepository extends JpaRepository<PrincipalRole, PrincipalRoleId> {

    List<PrincipalRole> findAllByPrincipalId(UUID principalId);
}
