package com.lonelydutchhound.adoptation.repository;

import com.lonelydutchhound.adoptation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findRoleByAuthority(String authority);


    @Query("SELECT roleId, principalId FROM principal_role where roleId in :ids")
    List<Role> findAllByIds(@Param("ids") List<UUID> ids);
}
