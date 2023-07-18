package com.juwoong.reactspringbootrestapi.content.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;

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

    @Override
    public List<Content> findAll() {
        RowMapper<Content> contentRowMapper = contentRowMapper();

        return jdbcTemplate.query("SELECT * FROM CONTENT", contentRowMapper);
    }

    private RowMapper<Content> contentRowMapper() {
        return (rs, rowNum) -> {
            UUID contentId = UUID.fromString(rs.getString("content_id"));
            String title = rs.getString("title");
            String text = rs.getString("text");
            ContentType contentType = ContentType.valueOf(rs.getString("content_type"));
            long price = rs.getLong("price");
            LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();

            return new Content(contentId, title, text, contentType, price, createdAt);
        };
    }

}
