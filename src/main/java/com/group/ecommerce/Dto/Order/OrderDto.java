package com.group.ecommerce.Dto.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    @JsonProperty("order_items")
    @NotEmpty(message = "Order items can't be empty")
    private List<OrderItemDto> orderItems;
    @JsonProperty("order_address")
    private OrderAddressDto orderAddress;
}
