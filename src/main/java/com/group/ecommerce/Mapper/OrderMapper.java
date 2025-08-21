package com.group.ecommerce.Mapper;

import com.group.ecommerce.Dto.Order.OrderDto;
import com.group.ecommerce.Entity.OrderAddressEntity;
import com.group.ecommerce.Entity.OrderEntity;
import com.group.ecommerce.Entity.OrderItemEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class OrderMapper {
    @Autowired
    private OrderAddressMapper orderAddressMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    public OrderEntity toEntity(OrderDto dto){
        OrderEntity entity = new OrderEntity();

        OrderAddressEntity orderAddress = orderAddressMapper.toEntity(dto.getOrderAddress());
        orderAddress.setOrder(entity);

        List<OrderItemEntity> orderItems = dto.getOrderItems().stream()
                        .map(orderItemDto -> {
                            OrderItemEntity orderItem = orderItemMapper.toEntity(orderItemDto);
                            orderItem.setOrder(entity);
                            return orderItem;
                        }).toList();

        entity.setOrderAddress(orderAddress);
        entity.setOrderItems(orderItems);

        return entity;
    }
}
