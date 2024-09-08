package com.harmlessprince.ecommerceApi.exceptions;

public class EmailTakenException extends RuntimeException {
    public EmailTakenException() {
        super("Email has already taken");
    }
}
