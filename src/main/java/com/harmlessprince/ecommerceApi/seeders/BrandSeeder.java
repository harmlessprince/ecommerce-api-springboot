package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.brand.Brand;
import com.harmlessprince.ecommerceApi.brand.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class BrandSeeder implements ISeeder {
    private final BrandRepository brandRepository;
    public void run() {
        String[] brands = new String[] {
                "Hisense", "LG", "Maxi",
                "Tecno", "Samsung", "Apple",
                "TCL", "Disney", "McDonald",
                "Toyota", "Lexus", "D&G",
                "Chanel", "Tom Ford", "Versace",
                "Calvin Klein", "Dior", "Google",
                "Gucci", "Prada", "Tesla", "Lenovo",
                "Nexus", "Sony"
        };
        if (brandRepository.count() >= brands.length) {
            return;
        }
        Arrays.stream(brands).forEach(brand -> {
            Optional<Brand> brandOptional = brandRepository.findByName(brand);
            if(brandOptional.isEmpty()) {
                Brand brandToAdd = new Brand();
                brandToAdd.setName(brand);
                brandRepository.save(brandToAdd);
            }
        });
    }
}
