package com.harmlessprince.ecommerceApi.brand;

import java.io.Serializable;

/**
 * DTO for {@link Brand}
 */
public record BrandResponse(Integer id, String name, String logo, String slug) implements Serializable {
}