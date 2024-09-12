package com.harmlessprince.ecommerceApi.product.controllers;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.mappers.VariationMapper;
import com.harmlessprince.ecommerceApi.product.responses.VariationResponse;
import com.harmlessprince.ecommerceApi.product.services.VariationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/variations")
public class VariationController {
    private final VariationService variationService;
    private final VariationMapper variationMapper;
    @GetMapping
    public ResponseEntity<CustomSuccessResponse<List<VariationResponse>>> getAllVariations() {
        List<Variation> variations = variationService.findAll();
        return ResponseEntity.ok(new CustomSuccessResponse<>(variationMapper.fromEntityList(variations)));
    }
}
