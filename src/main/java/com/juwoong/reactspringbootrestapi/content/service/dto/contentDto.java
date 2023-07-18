package com.juwoong.reactspringbootrestapi.content.service.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;

public record contentDto(UUID contentId, String title, String text, ContentType contentType, long price,
                         LocalDateTime createdAt) {

}
