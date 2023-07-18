package com.juwoong.reactspringbootrestapi.user.service.dto;

import java.util.UUID;

public record UserDto(UUID contentId, String email, String password, String name) {
}
