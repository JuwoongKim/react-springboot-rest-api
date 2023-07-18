package com.juwoong.reactspringbootrestapi.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reactspringbootrestapi.user.controller.request.UserRequest;
import com.juwoong.reactspringbootrestapi.user.service.UserService;
import com.juwoong.reactspringbootrestapi.user.service.dto.UserDto;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest.Create request) {
        UserDto response = userService.createUser(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
