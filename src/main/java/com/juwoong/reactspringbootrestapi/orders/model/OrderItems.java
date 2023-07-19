package com.juwoong.reactspringbootrestapi.orders.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter

public class OrderItems {

    private final UUID orderItemId;
    private final UUID orderId;
    private final UUID contentId;
    private final String contentTitle;
    private final long price;

    @JsonCreator
    public OrderItems(@JsonProperty("orderItemId") UUID orderItemId,
        @JsonProperty("orderId") UUID orderId,
        @JsonProperty("contentId") UUID contentId,
        @JsonProperty("contentTitle") String contentTitle,
        @JsonProperty("price") long price) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.price = price;
    }


    public OrderItems(UUID orderId, UUID contentId, String contentTitle, long price) {
        this.orderItemId = UUID.randomUUID();
        this.orderId = orderId;
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.price = price;
    }

}
