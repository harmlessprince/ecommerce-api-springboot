package com.harmlessprince.ecommerceApi.variation;

import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryResponse;

import java.io.Serializable;

/**
 * DTO for {@link Variation}
 */
public record VariationResponse(
        Integer id,
        String name,
        String slug,
        ProductCategoryResponse productCategory
) implements Serializable {
}