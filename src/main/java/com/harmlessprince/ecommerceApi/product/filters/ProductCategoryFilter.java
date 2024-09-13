package com.harmlessprince.ecommerceApi.product.filters;


import com.harmlessprince.ecommerceApi.bases.BaseFilter;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryFilter extends BaseFilter<ProductCategory> {

    public Specification<ProductCategory> filterByParentId(String parentId) {
        try {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("parentId"), safeParseInt(parentId));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
