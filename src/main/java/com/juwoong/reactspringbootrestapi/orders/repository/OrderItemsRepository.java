package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;

@Repository
public interface OrderItemsRepository {

    public void saveOrderItems(List<OrderItems> orderItemsList);
}
