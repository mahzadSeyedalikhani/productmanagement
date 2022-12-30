package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Setter
@Getter
@ToString
public class ProductDto {

    private String productId;

    private String productName;

    private Set<CategoryDto> categories;

    private String employeeNationalId;

    private boolean active = true;



}
