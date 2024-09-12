package com.harmlessprince.ecommerceApi.product.responses;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.Brand}
 */
public record BrandResponse(Integer id, String name, String logo, String slug) implements Serializable {
}