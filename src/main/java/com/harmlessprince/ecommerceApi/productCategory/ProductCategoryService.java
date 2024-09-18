package com.harmlessprince.ecommerceApi.productCategory;

import com.harmlessprince.ecommerceApi.contracts.IService;
import lombok.AllArgsConstructor;
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

    public List<ProductCategory> findAllByIdIn(List<Integer> ids) {
        return productCategoryRepository.findAllById(ids);
    }


    public List<ProductCategory> findAllAndFilter(Map<String, Object> requestParams) {
        Specification<ProductCategory> specification = productCategoryFilter.applyFilter(requestParams);
        return productCategoryRepository.findAll(specification);
    }
}
