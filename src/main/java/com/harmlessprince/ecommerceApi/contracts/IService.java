package com.harmlessprince.ecommerceApi.contracts;

import java.util.List;

public interface IService<M, R> {
    public M findById(int id);
    public M create(R data);
    public M update(M model, R data);
    public void delete(int id);
    public List<M> findAll();
}
