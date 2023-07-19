package com.juwoong.reactspringbootrestapi.orders.service.dto;

import java.util.UUID;

public record OrderItemDto (UUID orderItemId, UUID orderId, UUID contentId, String contentTitle, long price) {

}
