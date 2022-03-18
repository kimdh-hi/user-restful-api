package com.devblog.mobileappws.service;

import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.security.JwtTokenProvider;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;

public interface UserService {

    UserRequestDto createUser(UserRequestDto user);

    JwtTokenResponse login(LoginRequest loginRequest);
}
