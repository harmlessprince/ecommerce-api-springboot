package com.harmlessprince.ecommerceApi.product.responses;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.Variation}
 */
public record VariationResponse(
        Integer id,
        String name,
        String slug,
        ProductCategoryResponse productCategory
) implements Serializable {
}