package com.harmlessprince.ecommerceApi.handler;

import java.util.Map;

public record CustomSuccessResponse<T>(
        boolean status,
        String message,
        T data
) {
    public CustomSuccessResponse(T data) {
        this(true, "success", data);
    }

    public CustomSuccessResponse(String message, T data) {
        this(true, message, data);
    }
}
