package com.harmlessprince.ecommerceApi.variationOption;

import com.harmlessprince.ecommerceApi.variation.Variation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link VariationOption}
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