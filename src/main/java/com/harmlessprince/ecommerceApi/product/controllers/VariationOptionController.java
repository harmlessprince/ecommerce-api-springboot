package com.harmlessprince.ecommerceApi.product.controllers;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import com.harmlessprince.ecommerceApi.product.mappers.VariationOptionMapper;
import com.harmlessprince.ecommerceApi.product.responses.VariationOptionResponse;
import com.harmlessprince.ecommerceApi.product.responses.VariationResponse;
import com.harmlessprince.ecommerceApi.product.services.VariationOptionService;
import com.harmlessprince.ecommerceApi.product.services.VariationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/variation/options")
public class VariationOptionController {
    private final VariationService variationService;
    private final VariationOptionService variationOptionService;
    private final VariationOptionMapper variationOptionMapper;
    @GetMapping("/{variationId}")
    public ResponseEntity<CustomSuccessResponse<List<VariationOptionResponse>>> getAllVariations(@PathVariable Integer variationId) {
        List<VariationOption> variationOptions = variationOptionService.findAllByVariationId(variationId);
        List<VariationOptionResponse> variationOptionResponseList = variationOptionMapper.fromEntityList(variationOptions);
        return ResponseEntity.ok(new CustomSuccessResponse<>(variationOptionResponseList));
    }
}
