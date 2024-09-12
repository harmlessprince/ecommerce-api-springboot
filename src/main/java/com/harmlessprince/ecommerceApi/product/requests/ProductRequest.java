package com.harmlessprince.ecommerceApi.product.requests;

import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.ProductImage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Array;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link com.harmlessprince.ecommerceApi.product.Product}
 */
public record ProductRequest(Integer id,
                             @NotEmpty(message = "Product name is required") @Length(min = 1) String name,
                             @NotEmpty(message = "description is required") String description,
                             String imageUrl,
                             Integer brandId,
                             @NotNull(message = "categories is required")
                             @Size(min = 1, message = "The number of categories must be greater than 1")
                             List<@Min(value = 1, message = "Each category must be at least 1") Integer> categoriesId,
                             @NotNull(message = "categories is required")
                             @Size(min = 1, message = "The number of categories must be greater than 1")
                             List<@Min(value = 1, message = "Each product image id must be at least 1") Integer> productImagesId,
                             Brand brand,
                             Set<ProductCategory> productCategories
) implements Serializable {
}