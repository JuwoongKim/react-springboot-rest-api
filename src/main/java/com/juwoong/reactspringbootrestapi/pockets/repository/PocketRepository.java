package com.juwoong.reactspringbootrestapi.pockets.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;
import com.juwoong.reactspringbootrestapi.pockets.model.Pockets;

@Repository
public interface PocketRepository {

    public Pockets save(Pockets pockets);

    public Pockets findById(UUID pocketId);

    public void savePockets(List<Pockets> pocketsList);
}
