package com.juwoong.reactspringbootrestapi.orders.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juwoong.reactspringbootrestapi.orders.controller.request.OrderRequest;
import com.juwoong.reactspringbootrestapi.orders.model.Orders;
import com.juwoong.reactspringbootrestapi.orders.repository.OrderRepository;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderDto;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsService orderItemsService;

    public OrderService(OrderRepository orderRepository, OrderItemsService orderItemsService) {
        this.orderRepository = orderRepository;
        this.orderItemsService = orderItemsService;
    }

    @Transactional
    public OrderDto createOrder(OrderRequest.Create request) {
        Orders order = new Orders(request.getUserId(), request.getPrice(), request.getItems());

        Orders savedOrder = orderRepository.save(order);
        orderItemsService.saveOrderItems(savedOrder.getOrderId(), request.getItems());

        return toDTO(savedOrder);
    }

    private OrderDto toDTO(Orders order) {
        return new OrderDto(order.getOrderId(), order.getUserId(), order.getPrice(), order.getCreatedAt(),
            order.getItems());
    }

}
