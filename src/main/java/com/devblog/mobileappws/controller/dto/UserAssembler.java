package com.devblog.mobileappws.controller.dto;

import com.devblog.mobileappws.controller.dto.request.UserRequest;
import com.devblog.mobileappws.controller.dto.response.UserResponse;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import org.springframework.beans.BeanUtils;

public class UserAssembler {

    public static UserRequestDto toUserRequestDto(UserRequest userRequest) {
        UserRequestDto userRequestDto = new UserRequestDto();
        BeanUtils.copyProperties(userRequest, userRequestDto);

        return userRequestDto;
    }

    public static UserResponse toUserResponse(UserRequestDto userRequestDto) {
        return new UserResponse(
                userRequestDto.getId(),
                userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.isEmailVerificationStatus()
        );
    }

    public static UserResponse toUserResponse(UserResponseDto userResponseDto) {
        return new UserResponse(
                userResponseDto.getUserId(),
                userResponseDto.getName(),
                userResponseDto.getEmail(),
                userResponseDto.isEmailVerificationStatus()
        );
    }
}
