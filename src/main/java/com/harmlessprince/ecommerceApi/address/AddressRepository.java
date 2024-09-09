package com.harmlessprince.ecommerceApi.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
//    List<Address> findByCountryId(Integer countryId);
    List<Address> findByUserId(Integer id);
    List<Address> findByStateId(Integer id);
    List<Address> findByLocalGovernmentId(Integer id);
}
