package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface VariationRepository extends JpaRepository<Variation, Integer> {
    Optional<Variation> findByName(String name);

}