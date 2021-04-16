package com.lonelydutchhound.adoptation.services;

import com.lonelydutchhound.adoptation.model.User;
import com.lonelydutchhound.adoptation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(UUID id){
        return userRepository.findById(id).get();
    }
}
