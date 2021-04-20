package com.lonelydutchhound.adoptation.web.requests;


import com.lonelydutchhound.adoptation.model.Role;
import lombok.Value;

import java.util.List;

@Value
public class UserData {

    String username;
    String email;
    String password;
    List<Role> roles;

}
