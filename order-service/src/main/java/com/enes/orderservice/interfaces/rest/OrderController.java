package com.enes.orderservice.interfaces.rest;

import com.enes.orderservice.application.dto.CreateOrderRequest;
import com.enes.orderservice.application.service.CreateOrderService;
import com.enes.orderservice.domain.model.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest req){
        return createOrderService.create(req);
    }
}
