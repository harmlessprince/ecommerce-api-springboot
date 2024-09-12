package com.harmlessprince.ecommerceApi.product.services;


import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.requests.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements IService<Product, ProductRequest> {
    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product create(ProductRequest data) {
        return null;
    }

    @Override
    public Product update(Product model, ProductRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
