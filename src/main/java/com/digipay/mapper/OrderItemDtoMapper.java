package com.digipay.mapper;

import com.digipay.model.dto.OrderItemDto;
import com.digipay.model.entity.OrderItem;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemDtoMapper {

    List<OrderItemDto> orderItemToOrderItemDto(List<OrderItem> orderItem);
    List<OrderItem> orderItemDtoToOrderItem(List<OrderItemDto> orderItemDto);
}
