package com.example.tutorial.orders;

import com.example.tutorial.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "good_id", nullable = false)
    private Goods good;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "price_of_order")
    private Integer priceOfOrder;

    @Column(name = "is_discount")
    private Boolean isDiscount;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "is_credit")
    private Boolean isCredit;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "full_paid_date")
    private LocalDateTime fullPaidDate;

}
