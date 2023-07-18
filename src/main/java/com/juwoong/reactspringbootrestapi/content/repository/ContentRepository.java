package com.juwoong.reactspringbootrestapi.content.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.content.model.Content;

@Repository
public interface ContentRepository {

    public Content save(Content content);

    public List<Content> findAll();

    public Content findById(UUID contentId);

    public void deleteAll();

    public void deleteById(UUID contentId);

}
