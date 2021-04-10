package com.lonelydutchhound.adoptation.web.response;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class RegisterResponse {

    UUID id;
    String username;
}
