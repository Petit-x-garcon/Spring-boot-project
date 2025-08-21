package com.group.ecommerce.Mapper;

import com.group.ecommerce.Dto.Order.OrderAddressDto;
import com.group.ecommerce.Entity.OrderAddressEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderAddressMapper {

    public OrderAddressEntity toEntity(OrderAddressDto dto){
        OrderAddressEntity entity = new OrderAddressEntity();

        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setProvince(dto.getProvince());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCountry(dto.getCountry());

        return entity;
    }
}
