package com.juwoong.reactspringbootrestapi.user.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.user.model.Users;

@Repository
public interface UserRepository {

    public Users save(Users user);

    public Users findById(UUID userId);

    public Users findByEmailAndPassword(String email, String password);

}
