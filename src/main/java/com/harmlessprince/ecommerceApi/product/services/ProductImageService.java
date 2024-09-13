package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.ProductImage;
import com.harmlessprince.ecommerceApi.product.mappers.ProductImageMapper;
import com.harmlessprince.ecommerceApi.product.mappers.ProductMapper;
import com.harmlessprince.ecommerceApi.product.repositories.ProductImageRepository;
import com.harmlessprince.ecommerceApi.product.requests.ProductImageRequest;
import com.harmlessprince.ecommerceApi.product.requests.ProductRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductImageService implements IService<ProductImage, ProductImageRequest> {
    private final ProductImageRepository productImageRepository;
    private final ProductImageMapper productImageMapper;

    @Override
    public ProductImage findById(int id) {
        return null;
    }

    @Override
    public ProductImage create(ProductImageRequest data) {
        return null;
    }


    public List<ProductImage> createAll(List<ProductImageRequest> data) {
        return productImageRepository.saveAll(data.stream().map(productImageMapper::toEntity).toList());
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
