package com.harmlessprince.ecommerceApi.country;

import com.harmlessprince.ecommerceApi.handler.CustomSuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/countries")
public class CountryController {
    private final CountryRepository countryRepository;

    @GetMapping
    public CustomSuccessResponse<Iterable<Country>> getAllCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        return new CustomSuccessResponse<>(countries);
    }
}
