package com.devblog.mobileappws.controller.dto.response;

import javax.validation.constraints.NotBlank;

public class AddressResponse {
    private String address;
    private String detailAddress;

    public AddressResponse() {
    }

    public AddressResponse(String address, String detailAddress) {
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
