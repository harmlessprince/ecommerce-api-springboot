package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.repositories.BrandRepository;
import com.harmlessprince.ecommerceApi.product.requests.BrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService implements IService<Brand, BrandRequest> {
    private final BrandRepository brandRepository;
    @Override
    public Brand findById(int id) {
        return brandRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Brand not found"));
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
