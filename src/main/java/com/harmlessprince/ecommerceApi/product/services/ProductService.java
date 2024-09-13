package com.harmlessprince.ecommerceApi.product.services;


import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.exceptions.CustomBadRequestException;
import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.file.File;
import com.harmlessprince.ecommerceApi.file.FileService;
import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.ProductImage;
import com.harmlessprince.ecommerceApi.product.mappers.ProductImageMapper;
import com.harmlessprince.ecommerceApi.product.mappers.ProductMapper;
import com.harmlessprince.ecommerceApi.product.repositories.ProductRepository;
import com.harmlessprince.ecommerceApi.product.requests.ProductImageRequest;
import com.harmlessprince.ecommerceApi.product.requests.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements IService<Product, ProductRequest> {
    private final ProductRepository productRepository;
    private final FileService fileService;
    private final ProductImageService productImageService;
    private final ProductCategoryService productCategoryService;
    private final BrandService brandService;
    private final ProductMapper productMapper;
    private final ProductImageMapper productImageMapper;
    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product create(ProductRequest data) {
        // validate file IDs
        List<Integer> fileIds = data.files();
        List<File> fileList = fileService.findAllByIdInAndOwnerTypeIsNull(fileIds);
        if (fileList.isEmpty()) {
            throw new CustomResourceNotFoundException("Files not found or has already been associated to a product.");
        }
        List<Integer> retrievedFileIds = fileList.stream().map(File::getId).toList();
        fileIds.forEach(fileId -> {
            if (!retrievedFileIds.contains(fileId)) {
               throw new CustomResourceNotFoundException(String.format("File ID: %s  does not exist.", fileId));
            }
        });
        // validate category IDs
        List<Integer> categoryIds = data.categoriesId();
        List<ProductCategory> categoryList = productCategoryService.findAllByIdIn(categoryIds);
        List<Integer> retrievedCategoryIds = categoryList.stream().map(ProductCategory::getId).toList();
        categoryIds.forEach(categoryId -> {
            if (!retrievedCategoryIds.contains(categoryId)) {
                throw new CustomBadRequestException(String.format("Category ID: %s  does not exist.", categoryId));
            }
        });
        // validate brand id exists
        Brand brand = brandService.findById(data.brandId());
        // create product
        Boolean productWithBrandAndNameExist = productRepository.existsByNameAndBrandId(data.name(), brand.getId());
        if (productWithBrandAndNameExist) {
            throw new CustomBadRequestException(String.format("Product with name %s associated with brand: %s already exists.", data.name(), brand.getName()));
        }
        // initiate product images
        Product product = productMapper.toEntity(data);
        product.setBrand(brand);
        product.setProductCategories(new HashSet<>(categoryList));
        product = productRepository.save(product);
        List<ProductImageRequest> productImageRequests = new ArrayList<>();
        Product finalProduct = product;
        fileList.forEach(file -> {
            ProductImageRequest productImageRequest = new ProductImageRequest(
                    null,
                    file.getId(),
                    finalProduct.getId(),
                    finalProduct,
                    file
            );
            productImageRequests.add(productImageRequest);
        });
        List<ProductImage> productImages = productImageService.createAll(productImageRequests);
        product.setProductImages(productImages);
        return product;
    }

    @Override
    public Product update(Product model, ProductRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
