package com.harmlessprince.ecommerceApi.variationOption;

import com.harmlessprince.ecommerceApi.variation.VariationResponse;

import java.io.Serializable;

/**
 * DTO for {@link VariationOption}
 */
public record VariationOptionResponse(Integer id, String value, String slug,
                                       VariationResponse variation) implements Serializable {
}