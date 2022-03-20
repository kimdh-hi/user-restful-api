package com.devblog.mobileappws.controller.dto.request;

import javax.validation.constraints.NotBlank;

public class AddressRequest {

    @NotBlank(message = "주소는 공백일 수 없습니다.")
    private String address;
    @NotBlank(message = "상세주소는 공백일 수 없습니다.")
    private String detailAddress;

    public AddressRequest() {
    }

    public AddressRequest(String address, String detailAddress) {
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
