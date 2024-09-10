package com.harmlessprince.ecommerceApi.paymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Integer> {

    Optional<PaymentMethod> findByName(String country);
}
