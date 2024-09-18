package com.harmlessprince.ecommerceApi.variation;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VariationService implements IService<Variation, ProductCategoryRequest> {
    private VariationRepository variationRepository;
    @Override
    public Variation findById(int id) {
        return variationRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Variation not found"));
    }

    @Override
    public Variation create(ProductCategoryRequest input) {
        return null;
    }


    public Variation update(Variation variation, ProductCategoryRequest request) {
//        if (variation.getProductCategory().getParentId() > 0){
//            variation.setProductCategory(variation.getProductCategory());
//        }
        return null;
    }

    @Override
    public void delete(int id) {
        Variation variation = this.findById(id);
        variationRepository.delete(variation);
    }

    @Override
    public List<Variation> findAll() {
        return variationRepository.findAll();
    }
}
