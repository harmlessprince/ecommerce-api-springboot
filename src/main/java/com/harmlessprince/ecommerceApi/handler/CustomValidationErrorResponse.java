package com.harmlessprince.ecommerceApi.handler;


import java.util.Map;

public record CustomValidationErrorResponse(
        boolean status,
        String message,
        Map<String, String> errors
) {

}
