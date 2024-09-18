package com.harmlessprince.ecommerceApi.variation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VariationRepository extends JpaRepository<Variation, Integer> {
    Optional<Variation> findByName(String name);

}