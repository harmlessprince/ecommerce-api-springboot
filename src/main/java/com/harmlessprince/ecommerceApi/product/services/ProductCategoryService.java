package com.harmlessprince.ecommerceApi.product.services;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.filters.ProductCategoryFilter;
import com.harmlessprince.ecommerceApi.product.repositories.ProductCategoryRepository;
import com.harmlessprince.ecommerceApi.product.requests.ProductCategoryRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProductCategoryService implements IService<ProductCategory, ProductCategoryRequest> {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryFilter productCategoryFilter;
    @Override
    public ProductCategory findById(int id) {
        return null;
    }

    @Override
    public ProductCategory create(ProductCategoryRequest data) {
        return null;
    }

    @Override
    public ProductCategory update(ProductCategory model, ProductCategoryRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }


    public List<ProductCategory> findAllAndFilter(Map<String, Object> requestParams) {
        Specification<ProductCategory> specification = productCategoryFilter.applyFilter(requestParams);
        return productCategoryRepository.findAll(specification);
    }
}
