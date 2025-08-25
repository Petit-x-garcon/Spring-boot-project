package com.group.ecommerce.Controller;

import com.group.ecommerce.Dto.Product.ProductDto;
import com.group.ecommerce.Model.BaseResponseModel;
import com.group.ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<BaseResponseModel> createProduct(@Valid @RequestBody ProductDto payload){
        return  productService.createProduct(payload);
    }
}
