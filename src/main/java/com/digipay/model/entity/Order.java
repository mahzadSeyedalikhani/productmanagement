package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MYORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_item")
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private Customer customer;

    private BigDecimal totalOrderAmount;

    private Date orderDate;

    public Order(List<OrderItem> orderItems, Customer customer, BigDecimal totalOrderAmount,
                 String orderId, Date orderDate){
        this.orderItems = orderItems;
        this.customer = customer;
        this.totalOrderAmount = totalOrderAmount;
        this.orderDate = orderDate;
        this.orderId = orderId;
    }

    public Order() {

    }
}
