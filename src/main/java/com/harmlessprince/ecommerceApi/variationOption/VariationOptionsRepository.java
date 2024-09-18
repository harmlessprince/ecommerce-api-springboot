package com.harmlessprince.ecommerceApi.variationOption;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VariationOptionsRepository extends JpaRepository<VariationOption, Integer> {
    Optional<VariationOption> findByValue(String value);
    List<VariationOption> findAllByVariationId(Integer variationId);
}