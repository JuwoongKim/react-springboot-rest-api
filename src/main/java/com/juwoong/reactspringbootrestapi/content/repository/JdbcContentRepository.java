package com.juwoong.reactspringbootrestapi.content.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.juwoong.reactspringbootrestapi.content.model.Content;

@Repository
public class JdbcContentRepository implements ContentRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcContentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Content save(Content content) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("contentId", content.getContentId().toString())
            .addValue("title", content.getTitle())
            .addValue("text", content.getText())
            .addValue("contentType", content.getContentType().toString())
            .addValue("price", content.getPrice())
            .addValue("createdAt", content.getCreatedAt().toString());

        jdbcTemplate.update("INSERT INTO CONTENT VALUES (:contentId, :title, :text,:contentType,:price,:createdAt )",
            parameterSource);

        return content;
    }

}
