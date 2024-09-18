package com.harmlessprince.ecommerceApi.productCategory;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
