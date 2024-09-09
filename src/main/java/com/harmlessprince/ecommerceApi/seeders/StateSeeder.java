package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.country.CountryRepository;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.state.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StateSeeder {
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    public void run() {
        String[] states = new String[]{
                "Lagos",
                "Osun",
                "Oyo",
                "Ekiti",
        };
        Optional<Country> country = countryRepository.findByName("Nigeria");
        if (country.isEmpty()) {
            return;
        }
        for(String state : states) {
            if (stateRepository.findByName(state).isEmpty()){
                State createdState = new State();
                createdState.setCountry(country.get());
                createdState.setName(state);
                stateRepository.save(createdState);
            }

        }
    }
}
