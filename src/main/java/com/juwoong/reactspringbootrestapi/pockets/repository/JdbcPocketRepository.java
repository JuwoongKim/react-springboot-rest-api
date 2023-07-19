package com.juwoong.reactspringbootrestapi.pockets.repository;

import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.juwoong.reactspringbootrestapi.pockets.model.Pockets;

@Component
public class JdbcPocketRepository implements PocketRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcPocketRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pockets save(Pockets pockets) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("pocketId", pockets.getPocketId().toString())
            .addValue("userId", pockets.getUserId().toString())
            .addValue("contentId", pockets.getContentId().toString())
            .addValue("contentTitle", pockets.getContentTitle());

        jdbcTemplate.update("INSERT INTO USERS VALUES (:userId, :email, :password, :name )",
            parameterSource);

        return findById(pockets.getUserId());
    }

    @Override
    public Pockets findById(UUID pocketId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("pocketId", pocketId.toString());

        RowMapper<Pockets> pocketsRowMapper = pocketsRowMapper();

        return jdbcTemplate.queryForObject("SELECT * FROM POCKETS WHERE POCKET_ID = :pocketId", parameterSource,
            pocketsRowMapper);
    }

    private RowMapper<Pockets> pocketsRowMapper() {
        return (rs, rowNum) -> {
            UUID pocketId = UUID.fromString(rs.getString("pocket_id"));
            UUID userId = UUID.fromString(rs.getString("user_id"));
            UUID contentId = UUID.fromString(rs.getString("content_id"));
            String contentTitle = rs.getString("content_title");

            return new Pockets(pocketId, userId, contentId, contentTitle);
        };
    }

}
