package com.harmlessprince.ecommerceApi.product;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UpdateProductRequest(

        @Length(min = 2)
        String name,
        @Length(min = 10)
        String description,

        String imageUrl,

        @Positive(message = "brand id must be positive")
        Integer brandId
) {
}
