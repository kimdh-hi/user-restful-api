package com.devblog.mobileappws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    private String emailVerificationToken;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean emailVerificationStatus;

    public User(String name, String email, String password, String emailVerificationToken, boolean emailVerificationStatus) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.emailVerificationToken = emailVerificationToken;
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public void update(User updateUser) {
        if (!Objects.isNull(updateUser.getName())) this.name = updateUser.getName();
        if (!Objects.isNull(updateUser.getEmail())) this.email = updateUser.getEmail();
        if(!Objects.isNull(updateUser.getPassword())) this.password = updateUser.getPassword();
    }
}
