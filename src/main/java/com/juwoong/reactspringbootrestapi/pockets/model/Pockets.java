package com.juwoong.reactspringbootrestapi.pockets.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pockets {

    private final UUID pocketId;
    private final UUID userId;
    private final UUID contentId;
    private final String contentTitle;

    public Pockets(UUID userId, UUID contentId, String contentTitle) {
        this.pocketId = UUID.randomUUID();
        this.userId = userId;
        this.contentId = contentId;
        this.contentTitle = contentTitle;
    }
}
