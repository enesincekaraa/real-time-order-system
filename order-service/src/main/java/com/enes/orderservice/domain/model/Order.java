package com.enes.orderservice.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {
    private final UUID id;
    private BigDecimal totalAmount;
    private OrderStatus status;

    public Order(BigDecimal totalAmount) {
        this.id = UUID.randomUUID();
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CREATED;
    }
    public Order(UUID id, BigDecimal totalAmount, OrderStatus status) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    public void markAsPaid() {
        if (this.status !=OrderStatus.CREATED){
            throw new IllegalStateException("Cannot mark as paid");
        }
        this.status = OrderStatus.PAID;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
