package com.devblog.mobileappws.service.dto.response;

public class UserResponseDto {

    private Long userId;
    private String name;
    private String email;
    private boolean emailVerificationStatus;

    public UserResponseDto() {
    }

    public UserResponseDto(Long userId, String name, String email, boolean emailVerificationStatus) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
