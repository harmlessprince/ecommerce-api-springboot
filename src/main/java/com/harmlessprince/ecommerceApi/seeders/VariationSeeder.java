package com.harmlessprince.ecommerceApi.seeders;


import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import com.harmlessprince.ecommerceApi.product.repositories.ProductCategoryRepository;
import com.harmlessprince.ecommerceApi.product.repositories.VariationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class VariationSeeder implements ISeeder {
    private final VariationRepository variationRepository;
    private final ProductCategoryRepository productCategoryRepository;
    public void run() {
        Optional<ProductCategory> productCategory = productCategoryRepository.findByName("Mobile Phones");
        if(productCategory.isPresent()) {
            String[] variations = new String[]{
                    "Storage Capacity",
                    "Color",
                    "Size"
            };
            Arrays.stream(variations).forEach(item -> {
                if (variationRepository.findByName(item).isEmpty()) {
                    Variation newItem = new Variation();
                    newItem.setName(item);
                    newItem.setProductCategory(productCategory.get());
                    variationRepository.save(newItem);
                }
            });
        }


    }
}
