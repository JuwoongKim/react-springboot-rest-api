package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.orders.model.Orders;
import com.juwoong.reactspringbootrestapi.pockets.model.Pockets;

@Repository
public interface OrderRepository {

    public Orders save(Orders order);

    public Orders findById(UUID orderId);

    public List<Orders> findByUserId(UUID userId);
}
