package com.example.tutorial.controller;


import com.example.tutorial.dto.CreateCustomerDto;
import com.example.tutorial.dto.CustomerAgeDto;
import com.example.tutorial.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")


public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/available",params = {"age"})

    public @ResponseBody List<CustomerAgeDto> getCustomers(@RequestParam(value = "age") int age){
        return customerService.getCustomersAge(age);
    }

    @PostMapping(value = "/addCustomer")
    public void addCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        customerService.saveCustomer(createCustomerDto);
    }


}
