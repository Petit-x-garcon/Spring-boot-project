package com.group.ecommerce.Mapper;

import com.group.ecommerce.Dto.Order.OrderItemDto;
import com.group.ecommerce.Entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemEntity toEntity(OrderItemDto dto){
        OrderItemEntity entity = new OrderItemEntity();

        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        entity.setProductId(dto.getProductId());

        return entity;
    }
}
