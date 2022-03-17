package com.devblog.mobileappws.service;

import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.repository.UserRepository;
import com.devblog.mobileappws.service.dto.UserDtoAssembler;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserRequestDto createUser(UserRequestDto userRequestDto) {
        checkDuplicateEmail(userRequestDto.getEmail());

        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        return UserDtoAssembler.toUserRequestDto(savedUser);
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 Email 입니다. Email: " + email);
        }
    }
}
