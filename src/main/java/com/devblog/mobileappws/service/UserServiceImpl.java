package com.devblog.mobileappws.service;

import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.entity.Address;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.exception.entity.ErrorMessage;
import com.devblog.mobileappws.exception.exceptions.ResourceAlreadyExistsException;
import com.devblog.mobileappws.exception.exceptions.ResourceNotFoundException;
import com.devblog.mobileappws.repository.UserRepository;
import com.devblog.mobileappws.security.jwt.JwtTokenProvider;
import com.devblog.mobileappws.service.dto.UserDtoAssembler;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;
import com.devblog.mobileappws.service.dto.response.PageUserResponseDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<User> getUserList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public UserRequestDto createUser(UserRequestDto userRequestDto) {
        checkDuplicateEmail(userRequestDto.getEmail());

        Address address = UserDtoAssembler.toAddressEntity(userRequestDto.getAddressRequestDto());

        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddress(address);

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
        User user = findUser(userId);

        return UserDtoAssembler.toUserResponseDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = findUser(userId);

        User newUser = UserDtoAssembler.toUserEntity(userRequestDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.update(newUser);

        return UserDtoAssembler.toUserResponseDto(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        findUser(userId);
        userRepository.deleteById(userId);
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND.getMessage());
                }
        );
    }

    private void checkDuplicateEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ResourceAlreadyExistsException("이미 존재하는 Email 입니다. Email: " + email);
        }
    }
}
