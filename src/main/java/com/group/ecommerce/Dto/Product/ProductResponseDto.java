package com.group.ecommerce.Dto.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.group.ecommerce.Dto.Category.CategoryResponseDto;
import com.group.ecommerce.Dto.Supplier.SupplierResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"product_id","product_name","price","description",
        "size","color"})
public class ProductResponseDto {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("product_name")
    private String name;
    private Double price;
    private String description;
    private String size;
    private String color;
//    private CategoryResponseDto category;
//    private SupplierResponseDto supplier;
}
