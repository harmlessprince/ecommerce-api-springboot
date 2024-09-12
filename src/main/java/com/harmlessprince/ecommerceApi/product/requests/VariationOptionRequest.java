package com.harmlessprince.ecommerceApi.product.requests;

import com.harmlessprince.ecommerceApi.product.Variation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.VariationOption}
 */
public record VariationOptionRequest(
        Integer id,
        @NotEmpty(message = "Value is required")
        @Length(min = 1)
        String value,

        @NotEmpty(message = "variation is required")
        @Min(1)
        Integer variationId,

        Variation variation
) implements Serializable {
}