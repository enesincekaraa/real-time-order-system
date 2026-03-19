package com.enes.orderservice.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, java.util.UUID> {
}
