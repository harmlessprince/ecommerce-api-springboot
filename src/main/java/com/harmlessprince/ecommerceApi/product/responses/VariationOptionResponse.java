package com.harmlessprince.ecommerceApi.product.responses;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.VariationOption}
 */
public record VariationOptionResponse(Integer id, String value, String slug,
                                       VariationResponse variation) implements Serializable {
}