package com.juwoong.reactspringbootrestapi.content.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.juwoong.reactspringbootrestapi.content.controller.request.ContentRequest;
import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.repository.ContentRepository;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public ContentDto createContent(ContentRequest.Create request) {
        Content content = new Content(request.getTitle(), request.getText(), request.getContentType(),
            request.getPrice());

        return toDTO(contentRepository.save(content));
    }

    public List<ContentDto> getContents() {
        return contentRepository.findAll()
            .stream()
            .map(v -> toDTO(v))
            .toList();
    }

    private ContentDto toDTO(Content content) {
        return new ContentDto(content.getContentId(), content.getTitle(), content.getText(), content.getContentType(),
            content.getPrice(), content.getCreatedAt()
        );
    }

}
