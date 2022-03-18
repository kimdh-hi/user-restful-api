package com.devblog.mobileappws.service;

import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.exception.exceptions.ResourceAlreadyExistsException;
import com.devblog.mobileappws.exception.exceptions.ResourceNotFoundException;
import com.devblog.mobileappws.repository.UserRepository;
import com.devblog.mobileappws.security.jwt.JwtTokenProvider;
import com.devblog.mobileappws.service.dto.UserDtoAssembler;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public UserRequestDto createUser(UserRequestDto userRequestDto) {
        checkDuplicateEmail(userRequestDto.getEmail());

        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        return UserDtoAssembler.toUserRequestDto(savedUser);
    }

    @Override
    public JwtTokenResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new RuntimeException("로그인 정보가 올바르지 않습니다.");
        }

        String token = jwtTokenProvider.generateToken(loginRequest.getEmail());
        return new JwtTokenResponse(token);
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("존재하지 않는 사용자입니다. userId: " + userId);
                }
        );

        return UserDtoAssembler.toUserResponseDto(user);
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ResourceAlreadyExistsException("이미 존재하는 Email 입니다. Email: " + email);
        }
    }
}
