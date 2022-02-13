package com.example.tutorial.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderDto {
    private String goodName;
    private String customerName;

    public OrderDto(String goodName, String customerName) {
        this.goodName = goodName;
        this.customerName = customerName;
    }
}
