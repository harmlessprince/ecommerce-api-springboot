package com.harmlessprince.ecommerceApi.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
//    List<Address> findByCountryId(Integer countryId);
    List<Address> findByUserId(Integer id);
    List<Address> findByStateId(Integer id);
    List<Address> findByLocalGovernmentId(Integer id);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM addresses WHERE user_id = :userId AND is_default = true", nativeQuery = true)
    boolean existsDefaultAddressByUserId(Integer userId);

    Optional<Address> findByUserIdAndIsDefaultTrue(Integer userId);

    List<Address> findAllByUserIdAndIsDefaultIsTrue(Integer userId);

}
