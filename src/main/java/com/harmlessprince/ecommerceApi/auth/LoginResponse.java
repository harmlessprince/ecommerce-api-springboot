package com.harmlessprince.ecommerceApi.auth;

import com.harmlessprince.ecommerceApi.user.User;
import com.harmlessprince.ecommerceApi.user.UserResponse;

public record LoginResponse(
        UserResponse user,
        String token,
        long expiresIn
){}
