package com.juwoong.reactspringbootrestapi.orders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;
import com.juwoong.reactspringbootrestapi.orders.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

    private OrderItemsRepository orderItemsRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    public void saveOrderItems(UUID orderId, List<OrderItems> orderItemsList) {

        List<OrderItems> newOrderItemsList = new ArrayList<>();

        for (OrderItems orderItem : orderItemsList) {
            newOrderItemsList.add(
                new OrderItems(orderId, orderItem.getContentId(), orderItem.getContentTitle(), orderItem.getPrice()));
        }

        orderItemsRepository.saveOrderItems(newOrderItemsList);

    }

}
