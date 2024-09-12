package com.harmlessprince.ecommerceApi.product.filters;


import com.harmlessprince.ecommerceApi.bases.BaseFilter;
import com.harmlessprince.ecommerceApi.contracts.IFilter;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;

@Service
public class ProductCategoryFilter extends BaseFilter<ProductCategory> {

    public Specification<ProductCategory> filterByParentId(String parentId) {
        try {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("parentId"), safeParseInt(parentId));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
