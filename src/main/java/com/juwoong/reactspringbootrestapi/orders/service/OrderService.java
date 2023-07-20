package com.juwoong.reactspringbootrestapi.orders.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juwoong.reactspringbootrestapi.orders.controller.request.OrderRequest;
import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;
import com.juwoong.reactspringbootrestapi.orders.model.Orders;
import com.juwoong.reactspringbootrestapi.orders.repository.OrderRepository;
import com.juwoong.reactspringbootrestapi.orders.service.dto.OrderDto;
import com.juwoong.reactspringbootrestapi.pockets.service.PocketService;
import com.juwoong.reactspringbootrestapi.pockets.service.dto.PocketsDto;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsService orderItemsService;
    private final PocketService pocketService;

    public OrderService(OrderRepository orderRepository, OrderItemsService orderItemsService,
        PocketService pocketService) {
        this.orderRepository = orderRepository;
        this.orderItemsService = orderItemsService;
        this.pocketService = pocketService;
    }

    @Transactional
    public OrderDto createOrder(OrderRequest.Create request) {
        Orders order = new Orders(request.getUserId(), request.getPrice(), request.getItems());

        Orders savedOrder = orderRepository.save(order);
        orderItemsService.saveOrderItems(savedOrder.getOrderId(), request.getItems());
        pocketService.savePockets(request.getUserId(), request.getItems());

        return toDTO(savedOrder);
    }

    public List<OrderDto> findByUserId(UUID userId) {
        return orderRepository.findByUserId(userId)
            .stream()
            .map(v -> toDTO(v))
            .toList();
    }

    private OrderDto toDTO(Orders order) {
        return new OrderDto(order.getOrderId(), order.getUserId(), order.getPrice(), order.getCreatedAt(),
            order.getItems());
    }

}
