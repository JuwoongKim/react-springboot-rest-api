package com.juwoong.reactspringbootrestapi.orders.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItems {

    private final UUID orderItemId;
    private final UUID orderId;
    private final UUID contentId;
    private final String contentTitle;
    private final long price;

}
