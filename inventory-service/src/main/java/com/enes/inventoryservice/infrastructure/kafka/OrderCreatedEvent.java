package com.enes.inventoryservice.infrastructure.kafka;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        BigDecimal amount
) {
}
