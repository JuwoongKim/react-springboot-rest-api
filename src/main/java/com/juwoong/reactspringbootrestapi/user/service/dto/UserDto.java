package com.juwoong.reactspringbootrestapi.user.service.dto;

import java.util.UUID;

public record UserDto(UUID userId, String email, String password, String name) {
}
