package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.orders.model.Orders;

@Repository
public interface OrderRepository {

    public Orders save(Orders order);

    public Orders findById(UUID orderId);
}
