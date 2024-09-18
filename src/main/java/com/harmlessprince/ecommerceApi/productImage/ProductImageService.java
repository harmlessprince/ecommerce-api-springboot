package com.harmlessprince.ecommerceApi.productImage;

import com.harmlessprince.ecommerceApi.contracts.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
