package com.juwoong.reactspringbootrestapi.orders.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;

public record OrderDto(UUID orderId, UUID userId, long price, LocalDateTime createdAt, List<OrderItems> items) {

}
