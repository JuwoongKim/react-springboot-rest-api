package com.juwoong.reactspringbootrestapi.orders.service;

import org.springframework.stereotype.Service;

import com.juwoong.reactspringbootrestapi.orders.controller.request.OrderRequest;
import com.juwoong.reactspringbootrestapi.orders.model.Orders;
import com.juwoong.reactspringbootrestapi.orders.repository.OrderRepository;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderDto;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrder(OrderRequest.Create request) {
        Orders order = new Orders(request.getUserId(), request.getPrice(), request.getItems());

        return toDTO(orderRepository.save(order));
    }

    private OrderDto toDTO(Orders order) {
        return new OrderDto(order.getOrderId(), order.getUserId(), order.getPrice(), order.getCreatedAt(),
            order.getItems());
    }

}
