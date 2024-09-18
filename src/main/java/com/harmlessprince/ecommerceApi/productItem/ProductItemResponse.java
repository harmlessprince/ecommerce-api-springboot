package com.harmlessprince.ecommerceApi.productItem;

import com.harmlessprince.ecommerceApi.product.ProductResponse;
import com.harmlessprince.ecommerceApi.variationOption.VariationOptionResponse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * DTO for {@link ProductItem}
 */
public record ProductItemResponse(Integer id,
                                  String sku,
                                  Integer quantityInStock,
                                  BigDecimal price,
                                  BigDecimal salePrice,
                                  ProductResponse product,
                                  Set<VariationOptionResponse> variationOptions) implements Serializable {
}