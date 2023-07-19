package com.juwoong.reactspringbootrestapi.pockets.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.juwoong.reactspringbootrestapi.content.controller.request.ContentRequest;
import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;
import com.juwoong.reactspringbootrestapi.pockets.model.Pockets;
import com.juwoong.reactspringbootrestapi.pockets.repository.PocketRepository;
import com.juwoong.reactspringbootrestapi.pockets.service.dto.PocketsDto;

@Service
public class PocketService {

    private final PocketRepository pocketRepository;

    public PocketService(PocketRepository pocketRepository) {
        this.pocketRepository = pocketRepository;
    }

    public PocketsDto createPockets(UUID userId, UUID contentId, String contentTitle) {
        Pockets pockets = new Pockets(userId, contentId, contentTitle);

        return toDTO(pocketRepository.save(pockets));
    }

    private PocketsDto toDTO(Pockets pockets) {
        return new PocketsDto(pockets.getPocketId(), pockets.getUserId(), pockets.getContentId(),
            pockets.getContentTitle());
    }

}
