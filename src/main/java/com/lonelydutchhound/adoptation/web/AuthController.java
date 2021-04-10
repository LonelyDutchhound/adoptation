package com.lonelydutchhound.adoptation.web;

import com.lonelydutchhound.adoptation.model.Principal;
import com.lonelydutchhound.adoptation.services.AuthService;
import com.lonelydutchhound.adoptation.web.response.RegisterResponse;
import com.lonelydutchhound.adoptation.web.reuest.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ResponseBody
    @PostMapping("/register")
    private Optional<RegisterResponse> register(@RequestBody Register register) {
        Optional<RegisterResponse> response = Optional.empty();

        Principal principal = authService.registerUser(
                register.getUsername(),
                register.getPassword()
        );

        response = Optional.of(
                new RegisterResponse(
                        principal.getId(),
                        principal.getUsername()
                )
        );

        return response;

    }
}
