package com.harmlessprince.ecommerceApi.variation;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
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
