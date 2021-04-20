package com.lonelydutchhound.adoptation.web.controllers;

import com.lonelydutchhound.adoptation.model.User;
import com.lonelydutchhound.adoptation.services.UserService;
import com.lonelydutchhound.adoptation.web.requests.UserData;
import com.lonelydutchhound.adoptation.web.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signin")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {
        return userService.signin(username, password);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserData user) {
        return userService.signup(new User(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        ));
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @ResponseBody
    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponse search(@PathVariable String username) {
        User user = userService.search(username);
        UserResponse response = new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole().name());
        return response;
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public UserResponse whoami(HttpServletRequest req) {

        User user = userService.whoami(req);
        UserResponse response = new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole().name());

        return response;
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

}
