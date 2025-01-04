package com.scm.SmartContactManager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class user {

    @Id // for defining primary key
    private String userId;
    @Column(name = "user_name", nullable = false) // to define the properties of column.
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 10000)
    private String about;
    @Column(length = 10000)
    private String profilePic; // Link of Profile Picture
    private String phoneNumber;

    // Information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    // how user logged in, SELF, GOOGLE, FACEBOOK, GITHUB, LINKEDIN etc
    private Providers provider = Providers.SELF;
    private String providerUserId;

    // mapping it with contact, a user can have multiple contacts
    // cascade is used because is a user is deleted then all its contacts will be
    // deleted.
    // fetchType LAZY means contacts from DB will be fetched only when we want.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
}
