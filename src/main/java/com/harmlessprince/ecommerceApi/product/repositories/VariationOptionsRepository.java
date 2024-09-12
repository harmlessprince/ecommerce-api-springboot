package com.harmlessprince.ecommerceApi.product.repositories;

import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VariationOptionsRepository extends JpaRepository<VariationOption, Integer> {
    Optional<VariationOption> findByValue(String value);
    List<VariationOption> findAllByVariationId(Integer variationId);
}