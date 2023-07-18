package com.juwoong.reactspringbootrestapi.user.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Users {

    private final UUID userId;
    private String email;
    private String password;
    private String name;

    public Users(String email, String password, String name) {
        this.userId = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
