package com.devblog.mobileappws.service.dto;

import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import org.springframework.beans.BeanUtils;

public class UserDtoAssembler {

    public static User toUserEntity(UserRequestDto dto) {
        return new User(
                dto.getName(), dto.getEmail(), dto.getPassword(),
                dto.getEmailVerificationToken(), dto.isEmailVerificationStatus()
        );
    }

    public static UserRequestDto toUserRequestDto(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();
        BeanUtils.copyProperties(user, userRequestDto);
        return userRequestDto;
    }
}