package com.enes.orderservice.infrastructure.persistance;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    private UUID id;
    private BigDecimal totalAmount;
    private String status;
}
