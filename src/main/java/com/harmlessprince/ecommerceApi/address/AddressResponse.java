package com.harmlessprince.ecommerceApi.address;

import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.state.StateResponse;
import com.harmlessprince.ecommerceApi.user.UserResponse;


public record AddressResponse(
        Integer id,
        String street,
        String streetNumber,
        String postalCode,
        String city,
        UserResponse user,
        LocalGovernment localGovernment,
        StateResponse state,
        Boolean isDefault) {
}
