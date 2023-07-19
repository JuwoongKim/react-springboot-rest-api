package com.juwoong.reactspringbootrestapi.pockets.service.dto;

import java.util.UUID;

public record PocketsDto(UUID pocketId, UUID userId, UUID contentId, String contentTitle) {
}
