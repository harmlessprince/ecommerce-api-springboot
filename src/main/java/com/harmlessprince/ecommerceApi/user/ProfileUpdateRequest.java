package com.harmlessprince.ecommerceApi.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProfileUpdateRequest(
        @Length(min = 2, message = "full name can not be less than 2 characters")
        @NotNull(message = "full name is required")
        @NotEmpty(message = "full name can not be empty")
        String fullName,

        @Length(min = 10, message = "Phone number can not be less than 10 characters")
        @NotNull(message = "phone number is required")
        @NotEmpty(message = "phone number can not be empty")
        String phoneNumber,

        @Length(min = 5, message = "address can not be less than 5 characters")
        @NotNull(message = "address is required")
        @NotEmpty(message = "address can not be empty")
        String address
) {


}
