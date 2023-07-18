package com.juwoong.reactspringbootrestapi.content.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.juwoong.reactspringbootrestapi.content.controller.request.ContentRequest;
import com.juwoong.reactspringbootrestapi.content.service.ContentService;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/create")
    public ResponseEntity<ContentDto> createContent(@RequestBody ContentRequest.Create request) {
        ContentDto response = contentService.createContent(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
