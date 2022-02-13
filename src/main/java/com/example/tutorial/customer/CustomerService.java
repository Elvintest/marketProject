package com.example.tutorial.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerAgeDto> getCustomersAge(int age) {

        return customerRepository.findAll().stream()
                .map(customer ->
                        CustomerAgeDto.builder()
                                .name(customer.getName())
                                .age(convertDateToAge(customer.getBirthDay()))
                                .build()
                )
                .filter(customer -> customer.getAge() >= age)
                .collect(Collectors.toList());
    }

    private Integer convertDateToAge(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears();
    }


    public void saveCustomer(CreateCustomerDto createCustomerDto) {
        //builder from dto
        Customer customer = Customer.builder()
                .balance(createCustomerDto.getBalance())
                .name(createCustomerDto.getName())
                .birthDay(createCustomerDto.getBirthDay())
                .build();
        log.info("method of saving customer");
        customerRepository.save(customer);
        log.info(customer.getName() + " is saved");
    }


}
