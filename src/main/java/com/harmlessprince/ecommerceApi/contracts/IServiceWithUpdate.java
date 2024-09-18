package com.harmlessprince.ecommerceApi.contracts;

public interface IServiceWithUpdate<M, R> {
    public M update(M model, R data);
}
