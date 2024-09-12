package com.harmlessprince.ecommerceApi.product.responses;

import java.io.Serializable;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.ProductImage}
 */
public record ProductImageResponse(Integer id, String imageUrl) implements Serializable {
  }