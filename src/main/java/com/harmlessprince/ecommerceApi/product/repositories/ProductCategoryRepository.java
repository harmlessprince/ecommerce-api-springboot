package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Integer>, JpaSpecificationExecutor<ProductCategory> {
    Optional<ProductCategory> findByName(String country);
}
