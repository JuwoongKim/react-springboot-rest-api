package com.juwoong.reactspringbootrestapi.content.repository;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.content.model.Content;

@Repository
public interface ContentRepository {

    public Content save (Content content);

}
