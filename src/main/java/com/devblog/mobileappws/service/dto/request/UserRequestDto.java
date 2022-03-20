package com.devblog.mobileappws.service.dto.request;

import java.io.Serializable;

public class UserRequestDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String emailVerificationToken;
    private boolean emailVerificationStatus = false;

    private AddressRequestDto addressRequestDto;


    public UserRequestDto() {}

    public UserRequestDto(Long id, String name, String email, String password, String emailVerificationToken, boolean emailVerificationStatus, AddressRequestDto addressRequestDto) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.emailVerificationToken = emailVerificationToken;
        this.emailVerificationStatus = emailVerificationStatus;
        this.addressRequestDto = addressRequestDto;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public AddressRequestDto getAddressRequestDto() {
        return addressRequestDto;
    }

    public void setAddressRequestDto(AddressRequestDto addressRequestDto) {
        this.addressRequestDto = addressRequestDto;
    }
}
