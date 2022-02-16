package com.example.tutorial.controller;

import com.example.tutorial.entity.Goods;
import com.example.tutorial.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class GoodController {
    private final OrderService orderService;

    @Autowired
    public GoodController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/good")
    public String goodPost(@RequestBody Goods goods){
        return orderService.addGood(goods);
    }
}
