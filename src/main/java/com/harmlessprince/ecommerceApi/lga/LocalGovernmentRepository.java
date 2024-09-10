package com.harmlessprince.ecommerceApi.lga;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalGovernmentRepository extends CrudRepository<LocalGovernment, Integer> {
    Optional<LocalGovernment> findByName(String name);
    List<LocalGovernment> findByStateId(Integer stateId);
}
