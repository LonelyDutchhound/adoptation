package com.lonelydutchhound.adoptation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @Min(value = 2, message = "Name must contain at least two letters")
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

    @Column(name = "created_at", insertable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
