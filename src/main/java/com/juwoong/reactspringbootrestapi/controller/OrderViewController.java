package com.juwoong.reactspringbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juwoong.reactspringbootrestapi.orders.controller.request.OrderRequest;
import com.juwoong.reactspringbootrestapi.orders.service.OrderService;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderDto;


@Controller
@RequestMapping("/order")
public class OrderViewController {

    private OrderService orderService;

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest.Create request) {
        OrderDto response = orderService.createOrder(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
