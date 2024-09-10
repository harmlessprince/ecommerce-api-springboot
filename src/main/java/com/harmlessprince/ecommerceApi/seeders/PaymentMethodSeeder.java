package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.paymentMethod.PaymentMethod;
import com.harmlessprince.ecommerceApi.paymentMethod.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class PaymentMethodSeeder {
    private final PaymentMethodRepository paymentMethodRepository;
    public void run(){
        String[] countries = new String[]{
                "Credit Card",
                "Debit Card",
                "Transfer",
                "Cash",
                "Wallet",
                "Crypto Currency",
        };
        Arrays.stream(countries).forEach(country -> {
            if (paymentMethodRepository.findByName(country).isEmpty()){
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setName(country);
                paymentMethodRepository.save(paymentMethod);
            }
        });
    }
}
