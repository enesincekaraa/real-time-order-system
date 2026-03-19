package com.enes.orderservice.domain.repository;

import com.enes.orderservice.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(UUID id);
}
