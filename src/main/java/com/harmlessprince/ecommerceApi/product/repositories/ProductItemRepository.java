package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
}