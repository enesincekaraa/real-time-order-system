package com.enes.orderservice.domain.event;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID id,
        BigDecimal amount
) {
}
