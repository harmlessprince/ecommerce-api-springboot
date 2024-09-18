package com.harmlessprince.ecommerceApi.productImage;

import java.io.Serializable;

/**
 * DTO for {@link ProductImage}
 */
public record ProductImageResponse(Integer id, String imageUrl) implements Serializable {
  }