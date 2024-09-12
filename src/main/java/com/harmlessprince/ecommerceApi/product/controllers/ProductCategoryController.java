package com.harmlessprince.ecommerceApi.product.controllers;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.filters.ProductCategoryFilter;
import com.harmlessprince.ecommerceApi.product.mappers.ProductCategoryMapper;
import com.harmlessprince.ecommerceApi.product.responses.ProductCategoryResponse;
import com.harmlessprince.ecommerceApi.product.services.ProductCategoryService;
import com.harmlessprince.ecommerceApi.product.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<List<ProductCategoryResponse>>> getAllCategories(@RequestParam Map<String, Object> requestParams) {
        List<ProductCategory> productCategories = productCategoryService.findAllAndFilter(requestParams);
        return ResponseEntity.ok(new CustomSuccessResponse<>(productCategoryMapper.fromEntityList(productCategories)));
    }
}
