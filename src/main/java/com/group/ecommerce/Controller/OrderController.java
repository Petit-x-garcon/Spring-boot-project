package com.group.ecommerce.Controller;

import com.group.ecommerce.Dto.Base.Response;
import com.group.ecommerce.Dto.Order.OrderDto;
import com.group.ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<Response> createOrder(@RequestBody OrderDto payload){
        orderService.createOrder(payload);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Response.success("201", "success", "Order created successfully"));
    }
}
