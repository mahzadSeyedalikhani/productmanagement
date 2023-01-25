package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "PROFILE")
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_profileId")
    private String customerProfileId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_order")
    private Order order;

    private BigDecimal penalty;

    public CustomerProfile(){

    }

    public CustomerProfile(Customer customer, Order order, BigDecimal penalty){
        this.customer = customer;
        this.order = order;
        this.penalty = penalty;
    }
}
