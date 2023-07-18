package com.juwoong.reactspringbootrestapi.content.model;

import java.time.LocalDateTime;
import java.util.UUID;
import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Content {

    private final UUID contentId;
    private String title;
    private String text;
    private ContentType contentType;
    private long price;
    private final LocalDateTime createdAt;

    public Content(String title, String text, ContentType contentType, long price) {
        this.contentId = UUID.randomUUID();
        this.title = title;
        this.text = text;
        this.contentType = contentType;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public Content(UUID contentId, String title, String text, ContentType contentType, long price) {
        this.contentId = contentId;
        this.title = title;
        this.text = text;
        this.contentType = contentType;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

}
