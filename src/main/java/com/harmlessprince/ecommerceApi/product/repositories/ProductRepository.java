package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}