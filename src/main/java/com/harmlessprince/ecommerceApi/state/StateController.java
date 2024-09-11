package com.harmlessprince.ecommerceApi.state;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/states")
@Slf4j
public class StateController {
    private final StateRepository stateRepository;
    @GetMapping("/{countryId}")
    public ResponseEntity<CustomSuccessResponse<List<State>>> index(@PathVariable Integer countryId) {
        List<State> states = stateRepository.findByCountryId(countryId);
        return ResponseEntity.ok(new CustomSuccessResponse<>(states));
    }
}
