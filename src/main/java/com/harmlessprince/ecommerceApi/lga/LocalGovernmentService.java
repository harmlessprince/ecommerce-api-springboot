package com.harmlessprince.ecommerceApi.lga;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalGovernmentService {
    private final LocalGovernmentRepository localGovernmentRepository;
    public Boolean localGovernmentExistsById(Integer stateId) {
        return localGovernmentRepository.findById(stateId).isPresent();
    }
    public Optional<LocalGovernment> getLocalGovernmentById(Integer localGovernmentId) {
        return localGovernmentRepository.findById(localGovernmentId);
    }
}
