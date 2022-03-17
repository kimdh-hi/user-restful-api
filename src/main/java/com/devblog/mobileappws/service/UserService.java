package com.devblog.mobileappws.service;

import com.devblog.mobileappws.service.dto.request.UserRequestDto;

public interface UserService {

    UserRequestDto createUser(UserRequestDto user);
}
