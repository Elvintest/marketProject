package com.example.tutorial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Orders> ordersSet;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "full_price")
    private Integer full_price;

    @Column(name = "description")
    private String description;

    @Column(name = "remains")
    private Integer remains;
}
