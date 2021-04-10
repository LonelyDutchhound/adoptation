package com.lonelydutchhound.adoptation.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class PrincipalRoleId implements Serializable {

    private UUID principalId;

    private UUID roleId;

    public PrincipalRoleId() {
    }

    public PrincipalRoleId(UUID principalId, UUID roleId) {
        this.principalId = principalId;
        this.roleId = roleId;
    }

    public UUID getPrincipalId() {
        return principalId;
    }

    public UUID getRoleId() {
        return roleId;
    }
}
