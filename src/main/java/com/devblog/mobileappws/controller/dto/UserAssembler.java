package com.devblog.mobileappws.controller.dto;

import com.devblog.mobileappws.controller.dto.request.UserRequest;
import com.devblog.mobileappws.controller.dto.response.PageResponse;
import com.devblog.mobileappws.controller.dto.response.UserResponse;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UserAssembler {

    public static UserRequestDto toUserRequestDto(UserRequest userRequest) {
        UserRequestDto userRequestDto = new UserRequestDto(
                null, userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(), null, false,
                addressRequestDto);


        return userRequestDto;
    }

    public static UserResponse toUserResponse(UserRequestDto userRequestDto) {
        return new UserResponse(
                userRequestDto.getId(),
                userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.isEmailVerificationStatus());
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.isEmailVerificationStatus());
    }

    public static UserResponse toUserResponse(UserResponseDto userResponseDto) {
        return new UserResponse(
                userResponseDto.getUserId(),
                userResponseDto.getName(),
                userResponseDto.getEmail(),
                userResponseDto.isEmailVerificationStatus());
    }

    public static PageResponse<UserResponse> toPageUserResponse(Page<User> users) {

        List<UserResponse> content = users.stream()
                .map(UserAssembler::toUserResponse)
                .collect(Collectors.toList());


        return new PageResponse<UserResponse>(
                content,
                users.getSize(),
                users.getNumber(),
                users.isLast(),
                users.getTotalElements(),
                users.getTotalPages()
        );
    }
}
