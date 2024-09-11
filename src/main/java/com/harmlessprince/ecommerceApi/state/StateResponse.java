package com.harmlessprince.ecommerceApi.state;

import com.harmlessprince.ecommerceApi.country.Country;

public record StateResponse(
        Integer id,
        String name,
        Boolean status,
        Country country
        ) {
}
