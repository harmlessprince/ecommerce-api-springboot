package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.variation.Variation;
import com.harmlessprince.ecommerceApi.variationOption.VariationOption;
import com.harmlessprince.ecommerceApi.variationOption.VariationOptionsRepository;
import com.harmlessprince.ecommerceApi.variation.VariationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class VariationOptionSeeder implements ISeeder {
    private final VariationRepository variationRepository;
    private final VariationOptionsRepository variationOptionsRepository;

    public void run() {
        String[] variations = new String[]{
                "Storage Capacity",
                "Color",
                "Size"
        };
        Arrays.stream(variations).forEach(variation -> {
            Optional<Variation> currentVariation = variationRepository.findByName(variation);
            if (currentVariation.isEmpty()) {
                return;
            }
            String[] variationOptions = getVariationOptions(currentVariation);
            Arrays.stream(variationOptions).forEach(variationOption -> {
                if (variationOptionsRepository.findByValue(variationOption).isPresent()) {
                    return;
                }
                VariationOption newVariationOption = new VariationOption();
                newVariationOption.setVariation(currentVariation.get());
                newVariationOption.setValue(variationOption);
                variationOptionsRepository.save(newVariationOption);
            });
        });

    }

    private static String[] getVariationOptions(Optional<Variation> currentVariation) {
        String[] variationOptions = new String[]{};
        if (currentVariation.isEmpty()) {
            return variationOptions;
        }
        if (Objects.equals(currentVariation.get().getName(), "Storage Capacity")) {
            variationOptions = new String[]{"64GB", "128GB", "256GB", "512GB"};
        } else if (Objects.equals(currentVariation.get().getName(), "Color")) {
            variationOptions = new String[]{"Red", "Green", "Blue", "Alpha", "Grey", "Black"};
        } else if (Objects.equals(currentVariation.get().getName(), "Size")) {
            variationOptions = new String[]{"S", "M", "L", "XL", "XXL"};
        }
        return variationOptions;
    }
}
