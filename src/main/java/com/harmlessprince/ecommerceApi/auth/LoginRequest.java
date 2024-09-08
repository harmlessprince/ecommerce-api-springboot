package com.harmlessprince.ecommerceApi.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record LoginRequest(
        @Email(message = "Email is invalid")
        @NotNull(message = "Email is required")
        @NotEmpty(message = "Email can not be empty")
        String email,

        @Length(min = 2, message = "Password can not be less than 2 characters")
        @NotNull(message = "password is required")
        @NotEmpty(message = "password can not be empty")
        String password
) {
}

