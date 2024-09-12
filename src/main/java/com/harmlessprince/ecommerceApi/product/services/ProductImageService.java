package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.ProductImage;
import com.harmlessprince.ecommerceApi.product.requests.ProductImageRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductImageService implements IService<ProductImage, ProductImageRequest> {
    @Override
    public ProductImage findById(int id) {
        return null;
    }

    @Override
    public ProductImage create(ProductImageRequest data) {
        return null;
    }

    @Override
    public ProductImage update(ProductImage model, ProductImageRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ProductImage> findAll() {
        return List.of();
    }
}
