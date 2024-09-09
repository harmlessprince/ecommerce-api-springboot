package com.harmlessprince.ecommerceApi.state;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StateRepository extends CrudRepository<State, Integer> {
    Optional<State> findByName(String name);
    List<State> findByCountryId(Integer countryId);
}
