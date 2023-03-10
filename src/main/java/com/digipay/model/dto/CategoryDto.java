package com.digipay.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDto {

    private String categoryId;

    private String categoryName;

    private boolean active;
}
