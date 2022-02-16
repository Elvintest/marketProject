package com.example.tutorial.service;


import com.example.tutorial.entity.Customer;
import com.example.tutorial.repository.CustomerRepository;
import com.example.tutorial.dto.OrderDto;
import com.example.tutorial.entity.Goods;
import com.example.tutorial.entity.Orders;
import com.example.tutorial.repository.GoodRepository;
import com.example.tutorial.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final GoodRepository goodRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, GoodRepository goodRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.goodRepository = goodRepository;
        this.customerRepository = customerRepository;
    }

    public String addGood(Goods goods) {
        if (goodRepository.existsByName(goods.getName())){
            return "Such good already exists";
        }
        goodRepository.save(goods);
        return "the good has been successfully saved";
    }

    public void commitOrder(OrderDto orderDto) {
        Goods goodForOrder = goodRepository.findByName(orderDto.getGoodName());
        Customer customerForOrder = customerRepository.findByName(orderDto.getCustomerName());

        Orders order = Orders.builder()
                .good(goodForOrder)
                .customer(customerForOrder)
                .priceOfOrder(goodForOrder.getFull_price())
                .isDiscount(false)
                .discount(0)
                .isCredit(false)
                .orderDate(LocalDateTime.now())
                .fullPaidDate(LocalDateTime.now())
                .build();
        orderRepository.save(order);

        // subtracting the balance of the customer
        customerForOrder.setBalance(customerForOrder.getBalance() - goodForOrder.getFull_price());
        customerRepository.save(customerForOrder);

        //reducing remains of the ordered good
        goodForOrder.setRemains(goodForOrder.getRemains() - 1);
        goodRepository.save(goodForOrder);
    }


}
