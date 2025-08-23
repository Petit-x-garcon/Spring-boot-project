
package com.group.ecommerce.Service;

import com.group.ecommerce.Dto.Product.ProductDto;
import com.group.ecommerce.Entity.Product;
import com.group.ecommerce.Exception.Model.DuplicateException;
import com.group.ecommerce.Model.BaseResponseModel;
import com.group.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<BaseResponseModel> createProduct(ProductDto productDto) {
        if (productRepository.existsByName(productDto.getName())) {
            throw new DuplicateException("Product with name '" + productDto.getName() + "' is already existed");
        }

        Product productEntity = new Product();
        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setSize(productDto.getSize());
        productEntity.setColor(productDto.getColor());

        productRepository.save(productEntity);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BaseResponseModel("success", "Successfully created product"));
    }
}