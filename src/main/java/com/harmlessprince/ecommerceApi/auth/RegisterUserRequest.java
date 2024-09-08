package com.harmlessprince.ecommerceApi.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserRequest {
    Integer id;
    @Email(message = "Email is invalid")
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @Length(min = 2, message = "Password can not be less than 2 characters")
    @NotNull(message = "password is required")
    @NotEmpty(message = "password can not be empty")
    private String password;

    @Length(min = 2, message = "Full name can not be less than 2 characters")
    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name can not be empty")
    private String fullName;
}
