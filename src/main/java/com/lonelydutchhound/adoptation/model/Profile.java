package com.lonelydutchhound.adoptation.model;

import lombok.*;
import javax.persistence.*;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phoneNumber;

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
