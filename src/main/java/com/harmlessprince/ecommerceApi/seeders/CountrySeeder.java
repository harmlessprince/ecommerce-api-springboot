package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.country.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@AllArgsConstructor
@Component
public class CountrySeeder {
    private final CountryRepository countryRepository;
    public void run(){
        String[] countries = new String[]{
                "Australia",
                "Canada",
                "China",
                "Germany",
                "Italy",
                "Nigeria"
        };
        Arrays.stream(countries).forEach(country -> {
            if (countryRepository.findByName(country).isEmpty()){
                Country createdCountry = new Country();
                createdCountry.setName(country);
                countryRepository.save(createdCountry);
            }
        });
    }
}
