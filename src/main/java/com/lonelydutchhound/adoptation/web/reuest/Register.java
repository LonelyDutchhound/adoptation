package com.lonelydutchhound.adoptation.web.reuest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Register {

    @JsonProperty(required = true)
    String username;

    @JsonProperty(required = true)
    String password;
}
