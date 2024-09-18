package com.harmlessprince.ecommerceApi.brand;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link Brand}
 */
public record BrandRequest(Integer id,
                           @NotEmpty(message = "Name is required")
                           @Length(min = 1, max = 255) String name,
                           String logo
) implements Serializable {
}