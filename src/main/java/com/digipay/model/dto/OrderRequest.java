package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderRequest {

    private List<OrderItemRequest> orderItems;
    private String customerNationalCode;


}
