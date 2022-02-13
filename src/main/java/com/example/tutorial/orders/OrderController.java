package com.example.tutorial.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    OrderService orderService;

//TODO to make more proper response system with
//TODO to catch exceptions and set logging
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order")
    public void postOrder(@RequestBody OrderDto orderDto) {
        orderService.commitOrder(orderDto);
    }
}
