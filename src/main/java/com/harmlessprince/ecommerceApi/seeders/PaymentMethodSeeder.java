package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.paymentMethod.PaymentMethod;
import com.harmlessprince.ecommerceApi.paymentMethod.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class PaymentMethodSeeder implements ISeeder {
    private final PaymentMethodRepository paymentMethodRepository;
    public void run(){
        String[] paymentMethods = new String[]{
                "Credit Card",
                "Debit Card",
                "Transfer",
                "Cash",
                "Wallet",
                "Crypto Currency",
        };
        if (paymentMethodRepository.count() >= paymentMethods.length) {
            return;
        }
        Arrays.stream(paymentMethods).forEach(item -> {
            if (paymentMethodRepository.findByName(item).isEmpty()){
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setName(item);
                paymentMethodRepository.save(paymentMethod);
            }
        });
    }
}
