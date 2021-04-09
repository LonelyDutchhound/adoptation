package com.lonelydutchhound.adoptation.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private UUID id;

    @Column(name = "first_name")
    @Getter
    @Setter
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "phone_number")
    @Getter
    @Setter
    private String phoneNumber;

    @Column
    @Getter
    @Setter
    @NonNull
    private String email;

    @Column(name = "is_handler")
    @Getter
    @Setter
    private boolean isHandler;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date createdAt;

    public User(@NonNull String firstName, @NonNull String email) {
        this.firstName = firstName;
        this.email = email;
    }

    public User(@NonNull String firstName, String lastName, @NonNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(@NonNull String firstName, String lastName, String phoneNumber, @NonNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(@NonNull String firstName, String lastName, @NonNull String email, boolean isHandler) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isHandler = isHandler;
    }

    public User(@NonNull String firstName, String lastName, String phoneNumber, @NonNull String email, boolean isHandler) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isHandler = isHandler;
    }
}
