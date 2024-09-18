package com.harmlessprince.ecommerceApi.seeders;

import com.harmlessprince.ecommerceApi.contracts.ISeeder;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategory;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class ProductCategorySeeder implements ISeeder {
    private final ProductCategoryRepository productCategoryRepository;
    @Transactional
    public void run() {

        String[] categories = new String[]{
                "Clothing", "Book", "Laptops", "Jersey", "TV", "Mobile Phones", "Accessories",
                "Refrigerator", "Freezers", "Washing Machines", "Dryers", "Cookers", "Generators",
                "Audio", "Air Conditioners", "Gaming", "Refrigerators", "Gas Cookers", "Washing Machines",
                "Fans", "Power", "Cameras", "Coffee Machines", "Kitchen Appliances", "Vacuum Cleaners",
                "Jugs & Jars", "Body Weight Scales", "Garment Care", "Hair Clippers & Trimmers", "Water Dispensers",

        };
        this.SeedParentCategories(categories);
        String[] parentCategories = new String[]{"Mobile Phones", "Accessories"};
        this.seedChildrenCategories(parentCategories);
    }

    private void SeedParentCategories(String[] categories) {
        if (productCategoryRepository.count() >= categories.length) {
            return;
        }
        Arrays.stream(categories).forEach(item -> {
            if (productCategoryRepository.findByName(item).isEmpty()) {
                ProductCategory newItem = new ProductCategory();
                newItem.setName(item);
                productCategoryRepository.save(newItem);
                if (Objects.equals(newItem.getName(), "Accessories")) {
                    String[] childCategories = new String[]{"Phone Cases"};
                    Arrays.stream(childCategories).forEach(itemCategory -> {
                        if (productCategoryRepository.findByName(itemCategory).isEmpty()) {
                            ProductCategory newChildItem = new ProductCategory();
                            newChildItem.setName(itemCategory);
                            productCategoryRepository.save(newItem);
                        }
                    });

                }
                if (Objects.equals(newItem.getName(), "Mobile Phones")) {
                    String[] childCategories = new String[]{"Smartphones"};
                    Arrays.stream(childCategories).forEach(itemCategory -> {
                        if (productCategoryRepository.findByName(itemCategory).isEmpty()) {
                            ProductCategory newChildItem = new ProductCategory();
                            newChildItem.setName(itemCategory);
                            productCategoryRepository.save(newItem);
                        }
                    });

                }
            }
        });
    }

    private void seedChildrenCategories(String[] categories) {
        Arrays.stream(categories).forEach(parentisCategory -> {
            String[] childCategories = new String[]{};
            if (Objects.equals(parentisCategory, "Accessories")) {
                childCategories = new String[]{"Phone Cases"};
            } else if (Objects.equals(parentisCategory, "Mobile Phones")) {
                childCategories = new String[]{"Smartphones"};
            }

            if (childCategories.length > 0) {
                Arrays.stream(childCategories).forEach(itemCategory -> {
                    Optional<ProductCategory> parentItem = productCategoryRepository.findByName(parentisCategory);
                    Optional<ProductCategory> childItem = productCategoryRepository.findByName(itemCategory);
                    if (parentItem.isEmpty()) {
                        return;
                    }
                    if (childItem.isEmpty()) {
                        ProductCategory newChildItem = new ProductCategory();
                        newChildItem.setName(itemCategory);
                        newChildItem.setParentId(parentItem.get().getId());
                        productCategoryRepository.save(newChildItem);
                    }
                });
            }
        });
    }
}
