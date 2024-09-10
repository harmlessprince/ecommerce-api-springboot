package com.harmlessprince.ecommerceApi.state;

import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StateService {
    private final StateRepository stateRepository;

    public Boolean stateExistsById(Integer stateId) {
        return stateRepository.findById(stateId).isPresent();
    }

    public Optional<State> getStateById(Integer stateId) {
        return stateRepository.findById(stateId);
    }
}
