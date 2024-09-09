package com.harmlessprince.ecommerceApi.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddressRequest(

        Integer id,
        @NotEmpty(message = "street is required")
        String street,

        @NotEmpty(message = "street is required")
        String streetNumber,

        @NotEmpty(message = "postal code is required")
        String postalCode,

        @NotEmpty(message = "city is required")
        String city,

        @NotNull(message = "state is required")
        @Positive(message = "The state's Id must be greater than 0")
        Integer stateId,

        @NotNull(message = "local government is required")
        @Positive(message = "The local government's Id must be greater than 0")
        Integer localGovernmentId,

        @JsonProperty(defaultValue = "0")
        Boolean isDefault
) {
}
