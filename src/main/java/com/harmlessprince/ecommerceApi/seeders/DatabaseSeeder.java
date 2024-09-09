package com.harmlessprince.ecommerceApi.seeders;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DatabaseSeeder {
    private final CountrySeeder countrySeeder;
    private final StateSeeder stateSeeder;
    private final LocalGovernmentSeeder localGovernmentSeeder;
    @PostConstruct
    private void seed() {
       countrySeeder.run();
       stateSeeder.run();
       localGovernmentSeeder.run();
    }
}
