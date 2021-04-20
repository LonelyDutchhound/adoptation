package com.lonelydutchhound.adoptation.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, message = "Name must contain at least two letters")
    @Pattern(regexp = "[A-Za-zА-Яа-я]*", message = "Code contains illegal characters")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Za-zА-Яа-я]*", message = "Code contains illegal characters")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "[0-9]*", message = "Code contains illegal characters")
    @Column(name = "phone")
    private String phoneNumber;

    @NotBlank(message = "E-mail name cannot be empty")
    @Column
    private String email;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private Profile(ProfileBuilder builder){
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        email = builder.email;
    }

    public static class ProfileBuilder {
        private UUID id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;

        public ProfileBuilder setId(UUID id){
            this.id = id;
            return this;
        }

        public ProfileBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProfileBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProfileBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Profile build(){
            return new Profile(this);
        }
    }
}
