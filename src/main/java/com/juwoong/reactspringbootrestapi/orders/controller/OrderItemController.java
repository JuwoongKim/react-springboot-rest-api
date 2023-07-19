package com.juwoong.reactspringbootrestapi.orders.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reactspringbootrestapi.orders.service.OrderItemsService;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderItemDto;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    private final OrderItemsService orderItemsService;

    public OrderItemController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<OrderItemDto>> listByOrder(@PathVariable("id") UUID id) {
        List<OrderItemDto> response = orderItemsService.findByOrderId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
