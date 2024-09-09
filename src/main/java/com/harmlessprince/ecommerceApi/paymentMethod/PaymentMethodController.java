package com.harmlessprince.ecommerceApi.paymentMethod;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/payment-methods")
@AllArgsConstructor
public class PaymentMethodController {
    private final PaymentMethodRepository paymentMethodRepository;

    @GetMapping
    public ResponseEntity<Iterable<PaymentMethod>> getAllPaymentMethods() {
        return ResponseEntity.ok(paymentMethodRepository.findAll());
    }

}
