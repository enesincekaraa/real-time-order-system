package com.enes.orderservice.infrastructure.persistance;

import com.enes.orderservice.domain.model.Order;
import com.enes.orderservice.domain.model.OrderStatus;
import com.enes.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = mapToEntity(order);
        jpaOrderRepository.save(entity);
        return order;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return jpaOrderRepository.findById(id).map(this::mapToDomain);
    }


    private OrderEntity mapToEntity(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .build();
    }

    private Order mapToDomain(OrderEntity entity) {
        return new Order(entity.getId(),entity.getTotalAmount(),OrderStatus.valueOf(entity.getStatus()));

    }
}
