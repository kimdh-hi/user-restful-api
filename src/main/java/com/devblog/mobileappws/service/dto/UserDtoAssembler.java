package com.devblog.mobileappws.service.dto;

import com.devblog.mobileappws.entity.Address;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.service.dto.request.AddressRequestDto;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.AddressResponseDto;
import com.devblog.mobileappws.service.dto.response.PageUserResponseDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoAssembler {

    public static User toUserEntity(UserRequestDto dto) {
        return new User(
                dto.getName(), dto.getEmail(), dto.getPassword(),
                dto.getEmailVerificationToken(), dto.isEmailVerificationStatus()
        );
    }

    public static Address toAddressEntity(AddressRequestDto dto) {
        return new Address(dto.getAddress(), dto.getDetailAddress());
    }

    public static UserRequestDto toUserRequestDto(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();
        BeanUtils.copyProperties(user, userRequestDto);
        return userRequestDto;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.isEmailVerificationStatus(),
                new AddressResponseDto(user.getAddress().getAddress(), user.getAddress().getDetailAddress()));

        return userResponseDto;
    }

    public static PageUserResponseDto<UserResponseDto> toPageUserResponseDto(Page<User> users) {
        List<UserResponseDto> content = users.getContent().stream()
                .map(UserDtoAssembler::toUserResponseDto)
                .collect(Collectors.toList());

        return new PageUserResponseDto<UserResponseDto>(
                content,
                users.getSize(),
                users.getNumber(),
                users.isLast(),
                users.getTotalElements(),
                users.getTotalPages()
        );
    }
}
