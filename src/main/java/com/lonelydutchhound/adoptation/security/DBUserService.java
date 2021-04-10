package com.lonelydutchhound.adoptation.security;

import com.lonelydutchhound.adoptation.model.Principal;
import com.lonelydutchhound.adoptation.model.PrincipalRole;
import com.lonelydutchhound.adoptation.model.Role;
import com.lonelydutchhound.adoptation.repository.PrincipalRepository;
import com.lonelydutchhound.adoptation.repository.PrincipalRoleRepository;
import com.lonelydutchhound.adoptation.repository.RoleRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DBUserService implements UserDetailsService {

    private final PrincipalRepository principalRepository;
    private final PrincipalRoleRepository principalRoleRepository;
    private final RoleRepository roleRepository;

    public DBUserService(PrincipalRepository principalRepository, PrincipalRoleRepository principalRoleRepository, RoleRepository roleRepository) {
        this.principalRepository = principalRepository;
        this.principalRoleRepository = principalRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = null;

        Optional<Principal> principal = principalRepository.findPrincipalByUsername(username);


        if (principal.isPresent()) {
            List<PrincipalRole> principalRoles = principalRoleRepository.findAllByPrincipalId(principal.get().getId());

            List<Role> roles = roleRepository.findAllById(
                    principalRoles.stream().map(PrincipalRole::getRoleId).collect(Collectors.toList())
            );

            user = new User(
                    principal.get().getUsername(),
                    principal.get().getPassword(),
                    roles
            );
        }

        return user;
    }


}
