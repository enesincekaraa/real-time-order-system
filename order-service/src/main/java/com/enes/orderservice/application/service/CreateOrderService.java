package com.enes.orderservice.application.service;

import com.enes.orderservice.application.dto.CreateOrderRequest;
import com.enes.orderservice.domain.model.Order;
import com.enes.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOrderService {
    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(CreateOrderRequest req){
        Order order = new Order(req.amount());
        return orderRepository.save(order);
    }
}
