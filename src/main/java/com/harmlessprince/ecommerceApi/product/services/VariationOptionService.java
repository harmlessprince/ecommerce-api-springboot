package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import com.harmlessprince.ecommerceApi.product.repositories.VariationOptionsRepository;
import com.harmlessprince.ecommerceApi.product.repositories.VariationRepository;
import com.harmlessprince.ecommerceApi.product.requests.VariationOptionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VariationOptionService implements IService<VariationOption, VariationOptionRequest> {
    private final VariationOptionsRepository variationOptionsRepository;
    private final VariationRepository variationRepository;

    @Override
    public VariationOption findById(int id) {
        return null;
    }

    @Override
    public VariationOption create(VariationOptionRequest input) {
        return null;
    }

    @Override
    public VariationOption update(VariationOption model, VariationOptionRequest input) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<VariationOption> findAll() {
        return variationOptionsRepository.findAll();
    }

    public List<VariationOption> findAllByVariationId(Integer id) {
        return variationOptionsRepository.findAllByVariationId(id);
    }
}
