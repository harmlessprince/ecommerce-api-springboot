package com.harmlessprince.ecommerceApi.product.responses;

import com.harmlessprince.ecommerceApi.product.VariationOption;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.ProductItem}
 */
public record ProductItemResponse(Integer id,
                                  String sku,
                                  Integer quantityInStock,
                                  BigDecimal price,
                                  BigDecimal salePrice,
                                  ProductResponse product,
                                  Set<VariationOptionResponse> variationOptions) implements Serializable {
}