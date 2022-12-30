package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryAddRequest {

    private String parentCategory;
    private String categoryName;
}
