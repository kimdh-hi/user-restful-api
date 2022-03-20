package com.devblog.mobileappws.service.dto.request;

public class AddressRequestDto {

    private String address;
    private String detailAddress;

    public AddressRequestDto() {
    }

    public AddressRequestDto(String address, String detailAddress) {
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
