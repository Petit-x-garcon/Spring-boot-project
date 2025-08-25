package com.group.ecommerce.Mapper;




import com.group.ecommerce.Dto.Product.ProductDto;
import com.group.ecommerce.Dto.Product.ProductResponseDto;
import com.group.ecommerce.Entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto dto) {
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        return entity;
    }

    public ProductResponseDto toDto(Product entity) {
        ProductResponseDto dto = new ProductResponseDto();

        dto.setProductId(entity.getProductId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setColor(entity.getColor());
        dto.setDescription(entity.getDescription());

        return dto;

    }

    public List<ProductResponseDto> toDtoList(List<Product> entities) {
        if (entities == null || entities.isEmpty()){
            return new ArrayList<>();
        }
        return entities.stream()
                .map(product ->this.toDto(product))
                .collect(Collectors.toList());

    }
}


