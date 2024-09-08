package com.harmlessprince.ecommerceApi.user;

public record UserResponse(
        Integer id,
        String email,
        String fullName) {
}
