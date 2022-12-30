package com.digipay.model.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@ToString
public class ProductAddRequest {

    private String name;
    private Set<String> categories;
    private String employeeNationalId;
}
