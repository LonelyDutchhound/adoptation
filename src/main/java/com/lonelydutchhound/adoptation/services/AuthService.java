package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.Principal;
import com.lonelydutchhound.adoptation.model.PrincipalRole;
import com.lonelydutchhound.adoptation.model.Role;
import com.lonelydutchhound.adoptation.repository.PrincipalRepository;
import com.lonelydutchhound.adoptation.repository.PrincipalRoleRepository;
import com.lonelydutchhound.adoptation.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class AuthService {

    private static final String DEFAULT_USER_ROLE = "user";

    private final PrincipalRepository principalRepository;
    private final RoleRepository roleRepository;
    private final PrincipalRoleRepository principalRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(PrincipalRepository principalRepository, RoleRepository roleRepository,
                       PrincipalRoleRepository principalRoleRepository, PasswordEncoder passwordEncoder) {
        this.principalRepository = principalRepository;
        this.roleRepository = roleRepository;
        this.principalRoleRepository = principalRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Principal registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        Principal principal = new Principal(
                username,
                encodedPassword
        );

        principal = principalRepository.saveAndFlush(principal);

        Role role = getUserRole();

        PrincipalRole principalRole = new PrincipalRole(
                principal.getId(),
                role.getId()
        );

        principalRoleRepository.saveAndFlush(principalRole);

        return principal;
    }


    private Role getUserRole() {
        Optional<Role> userRole = roleRepository.findRoleByAuthority(DEFAULT_USER_ROLE);

        if (userRole.isEmpty()) {
            userRole = Optional.of(
                    roleRepository.saveAndFlush(new Role(DEFAULT_USER_ROLE))
            );
        }

        return userRole.orElseThrow(() -> new RuntimeException("Default user role not founded"));
    }
}
