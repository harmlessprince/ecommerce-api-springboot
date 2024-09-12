package com.harmlessprince.ecommerceApi.product.controllers;


import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.mappers.BrandMapper;
import com.harmlessprince.ecommerceApi.product.responses.BrandResponse;
import com.harmlessprince.ecommerceApi.product.services.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/brands")
public class BrandController {
    private final BrandService brandService;
    private final BrandMapper brandMapper;
    @GetMapping
    public ResponseEntity<CustomSuccessResponse<List<BrandResponse>>> getAllBrands() {
        List<Brand> brands = brandService.findAll();
        return ResponseEntity.ok(new CustomSuccessResponse<>(brandMapper.fromEntityList(brands)));
    }
}
