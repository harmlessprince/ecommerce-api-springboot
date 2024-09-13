package com.harmlessprince.ecommerceApi.product.controllers;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.mappers.ProductMapper;
import com.harmlessprince.ecommerceApi.product.requests.ProductRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductResponse;
import com.harmlessprince.ecommerceApi.product.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<List<ProductResponse>>> allProduct() {

        List<Product> products = productService.findAll();
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntityList(products)));
    }
    @PostMapping
    public ResponseEntity<CustomSuccessResponse<ProductResponse>> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.create(productRequest);
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntity(product)));
    }
}
