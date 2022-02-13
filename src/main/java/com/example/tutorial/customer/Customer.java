package com.example.tutorial.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CUSTOMER")

public class Customer {
    @Column(name = "NAME")
    private String  name;

    @Column(name = "BALANCE")
    private Long balance;

    @Column(name = "BIRTHDAY")
    private LocalDate birthDay;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
