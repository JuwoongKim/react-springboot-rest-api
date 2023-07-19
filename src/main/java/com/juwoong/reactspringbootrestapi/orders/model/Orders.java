package com.juwoong.reactspringbootrestapi.orders.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Orders {

    private final UUID orderId;
    private final UUID userId;
    private final long price;
    private final LocalDateTime createdAt;
    private List<OrderItems> items;

    public Orders(UUID userId, long price, List<OrderItems> items) {
        this.orderId = UUID.randomUUID();
        this.userId = userId;
        this.price = price;
        this.createdAt = LocalDateTime.now();
        this.items = items;
    }

    public Orders(UUID orderId, UUID userId, long price, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.price = price;
        this.createdAt = createdAt;
    }
}
