package com.devblog.mobileappws.controller;

import com.devblog.mobileappws.controller.dto.UserAssembler;
import com.devblog.mobileappws.controller.dto.request.UserRequest;
import com.devblog.mobileappws.controller.dto.response.UserResponse;
import com.devblog.mobileappws.service.UserService;
import com.devblog.mobileappws.service.dto.request.UserRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser() {

        return null;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        UserResponse userResponse = UserAssembler.toUserResponse(userService.createUser(userRequestDto));

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public String updateUser() {

        return null;
    }

    @DeleteMapping
    public String deleteUser() {

        return null;
    }
}
