package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.country.CountryRepository;
import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import com.harmlessprince.ecommerceApi.lga.LocalGovernmentRepository;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.state.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LocalGovernmentSeeder {
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;
    private final LocalGovernmentRepository localGovernmentRepository;

    public void run() {
        String[] items = new String[]{
                "Alimosho",
                "Agege",
                "Ojo",
                "Ikorodu",
                "Ikeja"
        };
        Optional<State> state = stateRepository.findByName("Lagos");
        if (state.isEmpty()) {
            return;
        }
        for (String item : items) {
            if (localGovernmentRepository.findByName(item).isEmpty()) {
                LocalGovernment createdLga = new LocalGovernment();
                createdLga.setState(state.get());
                createdLga.setName(item);
                localGovernmentRepository.save(createdLga);
            }

        }
    }
}
