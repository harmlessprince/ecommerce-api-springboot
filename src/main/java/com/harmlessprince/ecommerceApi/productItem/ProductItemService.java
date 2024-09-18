package com.harmlessprince.ecommerceApi.productItem;

import com.harmlessprince.ecommerceApi.contracts.IService;
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
