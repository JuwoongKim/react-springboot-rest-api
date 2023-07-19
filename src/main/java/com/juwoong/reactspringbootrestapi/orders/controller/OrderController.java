package com.juwoong.reactspringbootrestapi.orders.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reactspringbootrestapi.orders.controller.request.OrderRequest;
import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;
import com.juwoong.reactspringbootrestapi.orders.service.OrderService;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderDto;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createUser(@RequestBody OrderRequest.Create request) {
        OrderDto response = orderService.createOrder(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
