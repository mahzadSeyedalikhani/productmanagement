package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String nationalCode;

    public Customer(){

    }

    public Customer(String nationalCode, String customerId){
        this.nationalCode = nationalCode;
        this.customerId = customerId;
    }
}
