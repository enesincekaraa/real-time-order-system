package com.enes.orderservice.application.service;

import com.enes.orderservice.application.dto.CreateOrderRequest;
import com.enes.orderservice.domain.event.OrderCreatedEvent;
import com.enes.orderservice.domain.model.Order;
import com.enes.orderservice.domain.repository.OrderRepository;
import com.enes.orderservice.infrastructure.kafka.OrderEventProducer;
import org.springframework.stereotype.Service;


@Service

public class CreateOrderService {
    private final OrderRepository orderRepository;
    private final OrderEventProducer producer;

    public CreateOrderService(OrderRepository orderRepository, OrderEventProducer producer) {
        this.orderRepository = orderRepository;
        this.producer = producer;
    }

    public Order create(CreateOrderRequest req){
        Order order = new Order(req.amount());
        Order saved = orderRepository.save(order);
        producer.send(new OrderCreatedEvent(saved.getId(), saved.getTotalAmount()));
        return saved;
    }
}
