package com.example.tutorial.customer;
//это контроллер, тут эндпоинты, их запросы

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")


public class CustomerController {

    private CustomerService customerService;

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
