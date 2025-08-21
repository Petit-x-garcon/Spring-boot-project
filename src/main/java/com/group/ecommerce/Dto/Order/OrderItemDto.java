package com.group.ecommerce.Dto.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemDto {
    @NotEmpty(message = "Description can't be empty")
    private String description;
    @NotNull(message = "Quantity can't be null")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;
    @JsonProperty("product_id")
    @NotNull(message = "Product Id can't be null")
    private Long productId;
}
