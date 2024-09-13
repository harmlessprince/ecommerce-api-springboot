package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIdIn(Set<Integer> ids);
    Boolean existsByNameAndBrandId(String name, Integer brandId);
}