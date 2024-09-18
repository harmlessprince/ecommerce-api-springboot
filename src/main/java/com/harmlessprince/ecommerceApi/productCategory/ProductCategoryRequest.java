package com.harmlessprince.ecommerceApi.productCategory;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record ProductCategoryRequest(
        Integer id,
        @NotEmpty(message = "Name can not be empty")
        @Length(min = 1, max = 50)
        String name,

        @NotNull
        @Size(min = 1, message = "Parent ID must be greater or equal to 1")
        Integer parentId
) {
}
