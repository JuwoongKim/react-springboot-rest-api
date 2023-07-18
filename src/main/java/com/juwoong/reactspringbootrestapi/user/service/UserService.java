package com.juwoong.reactspringbootrestapi.user.service;

import org.springframework.stereotype.Service;

import com.juwoong.reactspringbootrestapi.content.controller.request.ContentRequest;
import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;
import com.juwoong.reactspringbootrestapi.user.controller.request.UserRequest;
import com.juwoong.reactspringbootrestapi.user.model.Users;
import com.juwoong.reactspringbootrestapi.user.repository.UserRepository;
import com.juwoong.reactspringbootrestapi.user.service.dto.UserDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser (UserRequest.Create request) {
        Users user = new Users(request.getEmail(), request.getPassword(), request.getName());

        return toDTO(userRepository.save(user));
    }

    private UserDto toDTO(Users user) {
        return new UserDto(user.getUserId(), user.getEmail(), user.getPassword(), user.getName());
    }

}
