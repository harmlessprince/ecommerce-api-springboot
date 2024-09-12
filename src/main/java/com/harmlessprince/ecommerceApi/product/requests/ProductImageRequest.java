package com.harmlessprince.ecommerceApi.product.requests;

import com.harmlessprince.ecommerceApi.product.Product;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.ProductImage}
 */
public record ProductImageRequest(Integer id,
                                  @NotEmpty(message = "Image url is required") String imageUrl,
                                  Product product
) implements Serializable {
}