package com.juwoong.reactspringbootrestapi.content.controller.request;

import java.util.UUID;

import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ContentRequest {

    @Getter
    @AllArgsConstructor
    public static class Create {

        String title;
        String text;
        ContentType contentType;
        long price;

    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        UUID contentId;
        String title;
        String text;
        ContentType contentType;
        long price;

    }

}
