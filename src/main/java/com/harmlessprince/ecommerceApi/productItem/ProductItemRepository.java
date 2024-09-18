package com.harmlessprince.ecommerceApi.productItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
}