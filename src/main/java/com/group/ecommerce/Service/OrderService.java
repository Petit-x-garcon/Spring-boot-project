package com.group.ecommerce.Service;

import com.group.ecommerce.Dto.Order.OrderDto;
import com.group.ecommerce.Entity.OrderEntity;
import com.group.ecommerce.Mapper.OrderMapper;
import com.group.ecommerce.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(OrderDto payload){
         OrderEntity entity = orderMapper.toEntity(payload);
         orderRepository.save(entity);
    }
}
