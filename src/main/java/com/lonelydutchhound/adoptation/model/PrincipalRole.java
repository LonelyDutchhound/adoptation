package com.lonelydutchhound.adoptation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity(name = "principal_role")
@IdClass(PrincipalRoleId.class)
public class PrincipalRole {

    @Id
    @Column(name = "principal_id")
    private UUID principalId;

    @Id
    @Column(name = "role_id")
    private UUID roleId;

    public PrincipalRole(UUID principalId, UUID roleId) {
        this.principalId = principalId;
        this.roleId = roleId;
    }
}
