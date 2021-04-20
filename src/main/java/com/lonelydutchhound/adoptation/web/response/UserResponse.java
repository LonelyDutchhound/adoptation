package com.lonelydutchhound.adoptation.web.response;

import lombok.Value;

import java.util.UUID;

@Value
public class UserResponse {

    UUID id;
    String username;
    String email;
    String role;

}
