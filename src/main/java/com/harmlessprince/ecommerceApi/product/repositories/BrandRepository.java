package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName(String name);
}