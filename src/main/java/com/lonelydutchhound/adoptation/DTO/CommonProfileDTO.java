package com.lonelydutchhound.adoptation.DTO;

import java.util.UUID;

public class CommonProfileDTO {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName, String lastName) {
        if (!(lastName == null)) {
            this.fullName = firstName + " " + lastName;
        } else {
            this.fullName = firstName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
