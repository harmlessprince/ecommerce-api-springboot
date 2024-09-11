package com.harmlessprince.ecommerceApi.handler;

public record CustomErrorResponse (
        boolean status,
        String message
) {
}
