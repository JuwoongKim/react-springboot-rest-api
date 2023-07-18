package com.juwoong.reactspringbootrestapi.user.repository;

import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.juwoong.reactspringbootrestapi.user.model.Users;

@Component
public class JdbcUserRepository implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Users save(Users user) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("userId", user.getUserId().toString())
            .addValue("email", user.getEmail())
            .addValue("password", user.getPassword())
            .addValue("name", user.getName());

        jdbcTemplate.update("INSERT INTO USERS VALUES (:userId, :email, :password, :name )",
            parameterSource);

        return findById(user.getUserId());
    }

    @Override
    public Users findById(UUID userId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("userId", userId.toString());

        RowMapper<Users> usersRowMapper = UsersRowMapper();

        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USER_ID = :userId", parameterSource,
            usersRowMapper);
    }

    private RowMapper<Users> UsersRowMapper() {
        return (rs, rowNum) -> {
            UUID userId = UUID.fromString(rs.getString("user_id"));
            String email = rs.getString("email");
            String password = rs.getString("password");
            String name = rs.getString("name");

            return new Users(userId, email, password, name);
        };
    }

}
