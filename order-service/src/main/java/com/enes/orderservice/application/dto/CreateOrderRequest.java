package com.enes.orderservice.application.dto;

import java.math.BigDecimal;

public record CreateOrderRequest(BigDecimal amount) {
}
