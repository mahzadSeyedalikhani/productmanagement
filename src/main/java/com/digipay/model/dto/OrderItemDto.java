package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemDto {

    private ProductDto product;
    private int quantity;
}
