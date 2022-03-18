package com.devblog.mobileappws.controller.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotEmpty(message = "이름은 필수입니다.")
    private String name;
    @Email(message = "이메일 형식으로 입력해주세요.")
    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;
    @Size(min = 4, max = 8, message = "비밀번호는 4~8자 까지 가능합니다.")
    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    public UserRequest() {
    }

    public UserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
}
