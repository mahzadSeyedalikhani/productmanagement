package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemRequest {

    private String product;
    private int quantity;
}
