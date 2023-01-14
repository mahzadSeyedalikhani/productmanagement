package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderDto {

    private String orderId;
    private List<OrderItemDto> orderItems;
    private CustomerDto customerNationalCode;
    private BigDecimal totalOrderAmount;
    private Date orderDate;

}
