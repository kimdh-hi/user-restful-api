package com.devblog.mobileappws.service;

import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.repository.UserRepository;
import com.devblog.mobileappws.service.dto.UserDtoAssembler;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserRequestDto createUser(UserRequestDto userRequestDto) {
        findByEmail(userRequestDto.getEmail());
        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        User savedUser = userRepository.save(user);

        return UserDtoAssembler.toUserRequestDto(savedUser);
    }


    private User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> {throw new IllegalArgumentException(email + " is not exist.");}
        );
    }
}
