package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MYRETURN")
public class OrderReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderReturnId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_order")
    private Order order;

    private Date returnDate;

    public OrderReturn(){
    }

    public OrderReturn(Order order, Date returnDate, String orderReturnId){
        this.order = order;
        this.returnDate = returnDate;
        this.orderReturnId = orderReturnId;
    }



}
