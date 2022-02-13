package com.example.tutorial.orders;


import com.example.tutorial.customer.Customer;
import com.example.tutorial.customer.CustomerRepository;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Native;
import java.time.LocalDateTime;

@Service
public class OrderService {
    OrderRepository orderRepository;
    GoodRepository goodRepository;
    CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, GoodRepository goodRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.goodRepository = goodRepository;
        this.customerRepository = customerRepository;
    }

    public String addGood(Goods goods) {
        try {
            goodRepository.save(goods);
        } catch (Exception e) {
            return e.getMessage().equals("could not execute statement; SQL [n/a];" +
                    " constraint [goods_name_key]; nested exception is" +
                    " org.hibernate.exception.ConstraintViolationException:" +
                    " could not execute statement") ? "such good already exists" : e.getMessage();
        }
        return "1";
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
