package com.devblog.mobileappws.service;

import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;
import com.devblog.mobileappws.service.dto.response.PageUserResponseDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getUserList(Pageable pageable);

    UserRequestDto createUser(UserRequestDto user);

    JwtTokenResponse login(LoginRequest loginRequest);

    UserResponseDto getUser(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);

}
