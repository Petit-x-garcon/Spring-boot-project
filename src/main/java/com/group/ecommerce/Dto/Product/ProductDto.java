package com.group.ecommerce.Dto.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be positive")
    private Double price;

    private String description;
    private String size;
    private String color;

//    @NotNull(message = "Category ID is required")
//    private Long categoryId;
//
//    @NotNull(message = "Supplier ID is required")
//  private Long supplierId;
}
