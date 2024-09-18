package com.harmlessprince.ecommerceApi.variation;

import com.harmlessprince.ecommerceApi.productCategory.ProductCategory;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.VariationOptions}
 */
public record VariationRequest(
        Integer id,
        @NotEmpty(message = "Name is required")
        @Length(min = 1)
        String name,
        ProductCategory productCategory
) implements Serializable {
}