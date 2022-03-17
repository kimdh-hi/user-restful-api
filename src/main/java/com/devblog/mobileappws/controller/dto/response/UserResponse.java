package com.devblog.mobileappws.controller.dto.response;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String emailVerificationToken;
    private boolean emailVerificationStatus;

    public UserResponse(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public UserResponse(Long id, String name, String email, boolean emailVerificationStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
