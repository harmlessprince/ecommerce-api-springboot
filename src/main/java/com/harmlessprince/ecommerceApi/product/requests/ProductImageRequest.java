package com.harmlessprince.ecommerceApi.product.requests;

import com.harmlessprince.ecommerceApi.file.File;
import com.harmlessprince.ecommerceApi.product.Product;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.ProductImage}
 */
public record ProductImageRequest(Integer id,
                                  @NotEmpty(message = "File id is required") Integer fileId,
                                  Integer productId,
                                  Product product,
                                  File file
) implements Serializable {
}