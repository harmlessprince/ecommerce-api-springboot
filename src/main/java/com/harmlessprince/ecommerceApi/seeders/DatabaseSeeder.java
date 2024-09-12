package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.product.Variation;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DatabaseSeeder {
    private final CountrySeeder countrySeeder;
    private final StateSeeder stateSeeder;
    private final LocalGovernmentSeeder localGovernmentSeeder;
    private final PaymentMethodSeeder paymentMethodSeeder;
    private final ProductCategorySeeder productCategorySeeder;
    private final VariationSeeder variationSeeder;
    private final VariationOptionSeeder variationOptionSeeder;
    private final UserSeeder userSeeder;
    private final BrandSeeder brandSeeder;

    @PostConstruct
    private void seed() {
        userSeeder.run();
        brandSeeder.run();
        countrySeeder.run();
        stateSeeder.run();
        localGovernmentSeeder.run();
        paymentMethodSeeder.run();
        productCategorySeeder.run();
        variationSeeder.run();
        variationOptionSeeder.run();
    }
}
