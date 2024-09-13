package com.harmlessprince.ecommerceApi.product.responses;

import com.harmlessprince.ecommerceApi.product.ProductImage;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.Product}
 */
public record ProductResponse(Integer id, String name, String description, String imageUrl, BrandResponse brand,
                              Set<ProductCategoryResponse> productCategories, List<ProductImageResponse> productImages) implements Serializable {
}