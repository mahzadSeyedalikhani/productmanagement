package com.digipay.mapper;

import com.digipay.model.dto.ProductDto;
import com.digipay.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ProductDtoMapper {

    ProductDto stringToProductDto(String productName);
}
