package com.harmlessprince.ecommerceApi.brand;


import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
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
