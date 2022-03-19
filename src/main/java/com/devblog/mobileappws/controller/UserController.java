package com.devblog.mobileappws.controller;

import com.devblog.mobileappws.controller.dto.UserAssembler;
import com.devblog.mobileappws.controller.dto.request.LoginRequest;
import com.devblog.mobileappws.controller.dto.request.UserRequest;
import com.devblog.mobileappws.controller.dto.response.PageResponse;
import com.devblog.mobileappws.controller.dto.response.UserResponse;
import com.devblog.mobileappws.entity.User;
import com.devblog.mobileappws.service.UserService;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import com.devblog.mobileappws.service.dto.response.JwtTokenResponse;
import com.devblog.mobileappws.service.dto.response.PageUserResponseDto;
import com.devblog.mobileappws.service.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<PageResponse<UserResponse>> getUserList(Pageable pageable) {
        Page<User> userList = userService.getUserList(pageable);
        return ResponseEntity.ok(UserAssembler.toPageUserResponse(userList));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);

        return ResponseEntity.ok(UserAssembler.toUserResponse(userResponseDto));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid  @RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        UserResponse userResponse = UserAssembler.toUserResponse(userService.createUser(userRequestDto));

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @Valid @RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        UserResponseDto userResponseDto = userService.updateUser(userId, userRequestDto);

        return ResponseEntity.ok(UserAssembler.toUserResponse(userResponseDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
