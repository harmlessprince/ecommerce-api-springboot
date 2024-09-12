package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.ProductItem;
import com.harmlessprince.ecommerceApi.product.requests.ProductItemRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductItemService implements IService<ProductItem, ProductItemRequest> {
    @Override
    public ProductItem findById(int id) {
        return null;
    }

    @Override
    public ProductItem create(ProductItemRequest data) {
        return null;
    }

    @Override
    public ProductItem update(ProductItem model, ProductItemRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ProductItem> findAll() {
        return List.of();
    }
}
