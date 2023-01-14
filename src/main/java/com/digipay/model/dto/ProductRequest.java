package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@ToString
public class ProductRequest {

    private String name;
    private int productCount;
    private Set<String> categories;
    private String employeeNationalId;
    private String price;
}
