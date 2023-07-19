package com.juwoong.reactspringbootrestapi.content.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;

@SpringBootTest
class JdbcContentRepositoryTest {

    @Autowired
    ContentRepository contentRepository;

    @Test
    void save() {
        Content content = new Content("title", "text", ContentType.ACTION, 100);
        contentRepository.save(content);
    }
}