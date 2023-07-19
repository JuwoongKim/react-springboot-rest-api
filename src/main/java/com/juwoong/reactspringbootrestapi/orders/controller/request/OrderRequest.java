package com.juwoong.reactspringbootrestapi.orders.controller.request;

import java.util.List;
import java.util.UUID;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class OrderRequest {

    @Getter
    @AllArgsConstructor
    public static class Create {

        private UUID userId;
        private long price;
        private List<OrderItems> items;

    }
}
