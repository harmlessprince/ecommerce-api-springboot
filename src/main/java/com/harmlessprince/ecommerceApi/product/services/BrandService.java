package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.repositories.BrandRepository;
import com.harmlessprince.ecommerceApi.product.requests.BrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService implements IService<Brand, BrandRequest> {
    private final BrandRepository brandRepository;
    @Override
    public Brand findById(int id) {
        return null;
    }

    @Override
    public Brand create(BrandRequest data) {
        return null;
    }

    @Override
    public Brand update(Brand model, BrandRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
