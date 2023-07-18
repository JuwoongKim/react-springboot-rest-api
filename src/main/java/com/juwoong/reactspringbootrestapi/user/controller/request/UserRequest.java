package com.juwoong.reactspringbootrestapi.user.controller.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserRequest {

    @Getter
    @AllArgsConstructor
    public static class Create {

        private String email;
        private String password;
        private String name;

    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        private UUID contentId;
        private String email;
        private String password;
        private String name;

    }

}
