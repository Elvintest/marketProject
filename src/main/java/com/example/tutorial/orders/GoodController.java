package com.example.tutorial.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class GoodController {
    OrderService orderService;

    @Autowired
    public GoodController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/good")
    public String goodPost(@RequestBody Goods goods){
        return orderService.addGood(goods);
    }
}
