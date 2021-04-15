package com.lonelydutchhound.adoptation.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@ToString
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    @Column(name = "is_handler")
    private boolean isHandler;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
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

    public User(UUID id, @NonNull String firstName, String lastName, String phoneNumber, @NonNull String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
