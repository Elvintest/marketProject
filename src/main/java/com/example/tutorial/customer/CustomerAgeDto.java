package com.example.tutorial.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CustomerAgeDto {

    private String  name;
    private Integer age;


    public CustomerAgeDto(String name, Integer age) {
        this.name = name;
        this.age = age;

    }
}
