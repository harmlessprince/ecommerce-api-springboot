package com.harmlessprince.ecommerceApi.product;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    @Transactional
    public ResponseEntity<CustomSuccessResponse<List<ProductResponse>>> allProduct() {

        List<Product> products = productService.findAll();
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntityList(products)));
    }
    @PostMapping
    public ResponseEntity<CustomSuccessResponse<ProductResponse>> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.create(productRequest);
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntity(product)));
    }
    @PatchMapping("/{productId}")
    public ResponseEntity<CustomSuccessResponse<ProductResponse>> updateProduct(
            @RequestBody @Valid UpdateProductRequest request,
            @PathVariable Integer productId
    ) {
        Product product = productService.findByIdWithBrand(productId);
        productService.update(product, request);
        product = productService.findByIdWithRelations(productId);
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntity(product), "product updated"));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CustomSuccessResponse<ProductResponse>> showProduct(
            @PathVariable Integer productId
    ) {
        Product  product = productService.findByIdWithRelations(productId);
        return ResponseEntity.ok(new CustomSuccessResponse<>(productMapper.fromEntity(product), "Product retrieved"));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<CustomSuccessResponse<Object>> deleteProduct(
            @PathVariable Integer productId
    ) {
        productService.findById(productId);
        productService.delete(productId);
        return ResponseEntity.ok(new CustomSuccessResponse<>(null, "Product deleted successfully"));
    }
}
