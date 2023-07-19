package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;

@Repository
public interface OrderItemsRepository {

    public void saveOrderItems(List<OrderItems> orderItemsList);

    public List<OrderItems> findByOrderId(UUID orderId);
}
