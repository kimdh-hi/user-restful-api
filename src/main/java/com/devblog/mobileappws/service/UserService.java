package com.devblog.mobileappws.service;

import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;

public interface UserService {

    UserRequestDto createUser(UserRequestDto user);

    JwtTokenResponse login(LoginRequest loginRequest);

    UserResponseDto getUser(Long userId);
}
