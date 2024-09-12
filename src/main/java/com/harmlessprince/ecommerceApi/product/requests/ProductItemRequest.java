package com.harmlessprince.ecommerceApi.product.requests;

import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.ProductItem}
 */
public record ProductItemRequest(Integer id,
                                 @NotNull(message = "Quantity in stock is required") @Min(message = "Quantity in stock must be greater than 0", value = 1) @Positive(message = "quantity in stock must be greater than 0")
                                 Integer quantityInStock,
                                 @Min(message = "price must be greater than 0", value = 1) @Positive(message = "Price must be greater than 0")
                                 BigDecimal price,
                                 @Min(message = "sale price must be greater than 0", value = 1) @Positive(message = "sale price must be greater than 0")
                                 BigDecimal salePrice,
                                 @Positive()
                                 @NotNull(message = "product id is required")
                                 Integer productId,

                                 @NotNull(message = "variation options is required")
                                 @Size(min = 1, message = "The number of variation option's ids must be greater than 1")
                                 List<Integer> variationOptionIds,

                                 Product product,
                                 Set<VariationOption> variationOptions
                                 ) implements Serializable {
}