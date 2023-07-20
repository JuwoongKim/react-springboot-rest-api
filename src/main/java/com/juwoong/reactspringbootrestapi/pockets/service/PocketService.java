package com.juwoong.reactspringbootrestapi.pockets.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;
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

    public void savePockets(UUID userId, List<OrderItems> orderItemsList) {

        List<Pockets> pocketsList = new ArrayList<>();

        for (OrderItems orderItem : orderItemsList) {
            pocketsList.add(
                new Pockets(userId, orderItem.getContentId(), orderItem.getContentTitle()));
        }

        pocketRepository.savePockets(pocketsList);

    }

    public List<PocketsDto> findByUserId(UUID userId) {
        return pocketRepository.findByUserId(userId)
            .stream()
            .map(v -> toDTO(v))
            .toList();
    }


    public void deleteByUserId(UUID userId) {
        pocketRepository.deleteByUserId(userId);
    }


    private PocketsDto toDTO(Pockets pockets) {
        return new PocketsDto(pockets.getPocketId(), pockets.getUserId(), pockets.getContentId(),
            pockets.getContentTitle());
    }

}
