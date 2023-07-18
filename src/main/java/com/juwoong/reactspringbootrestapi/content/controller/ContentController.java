package com.juwoong.reactspringbootrestapi.content.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/list")
    public ResponseEntity<List<ContentDto>> createContent() {
        List<ContentDto> response = contentService.getContents();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ContentDto> detail(@PathVariable("id") UUID id) {
        ContentDto voucherDto = contentService.findById(id);

        return ResponseEntity.ok(voucherDto);
    }

}
