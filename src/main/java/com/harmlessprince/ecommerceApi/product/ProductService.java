package com.harmlessprince.ecommerceApi.product;


import com.harmlessprince.ecommerceApi.brand.BrandService;
import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.contracts.IServiceWithUpdate;
import com.harmlessprince.ecommerceApi.exceptions.CustomBadRequestException;
import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import com.harmlessprince.ecommerceApi.file.File;
import com.harmlessprince.ecommerceApi.file.FileService;
import com.harmlessprince.ecommerceApi.brand.Brand;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategory;
import com.harmlessprince.ecommerceApi.productImage.ProductImage;
import com.harmlessprince.ecommerceApi.productImage.ProductImageMapper;
import com.harmlessprince.ecommerceApi.productImage.ProductImageRequest;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryService;
import com.harmlessprince.ecommerceApi.productImage.ProductImageService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements IService<Product, ProductRequest>, IServiceWithUpdate<Product, UpdateProductRequest> {
    private final ProductRepository productRepository;
    private final FileService fileService;
    private final ProductImageService productImageService;
    private final ProductCategoryService productCategoryService;
    private final BrandService brandService;
    private final ProductMapper productMapper;
    private final ProductImageMapper productImageMapper;
    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Product not found"));
    }

    public Product findByIdWithRelations(int id) {
        return productRepository.findByIdWithRelations(id).orElseThrow(() -> new CustomResourceNotFoundException("Product not found"));
    }

    public Product findByIdWithBrand(int id) {
        return productRepository.findByIdWithBrand(id).orElseThrow(() -> new CustomResourceNotFoundException("Product not found"));
    }

    @Override
    @Transactional
    public Product create(ProductRequest data) {
        // validate file IDs
        List<File> fileList = this.validateFileIds(data.files());
        // validate category IDs
        List<ProductCategory> categoryList = this.validateCategoryIds(data.categoriesId());
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
        List<ProductImageRequest> productImageRequests = productImageMapper.fromFileList(fileList, product);
        Set<ProductImage> productImages = new HashSet<>(productImageService.createAll(productImageRequests));
        product.setProductImages(productImages);
        return product;
    }

    @Override
    @Transactional
    public Product update(Product model, UpdateProductRequest data) {
        if (Optional.ofNullable(data.brandId()).isPresent()) {
            Brand brand = brandService.findById(data.brandId());
            model.setBrand(brand);
        }
        Product product = productMapper.toEntityForUpdate(data, model);
        Boolean productWithBrandAndNameExist = productRepository.existsByNameAndBrandIdAndExemptProductId(data.name(), product.getBrand(), product.getId());
        if (productWithBrandAndNameExist) {
            throw new CustomBadRequestException(String.format("Product with name %s associated with brand: %s already exists.", data.name(), model.getBrand().getName()));
        }
        product = productRepository.save(product);
        return product;
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAllProducts();
    }

    private List<File> validateFileIds(List<Integer> fileIds) {
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
        return fileList;
    }
    private List<ProductCategory> validateCategoryIds(List<Integer> categoryIds) {
        List<ProductCategory> categoryList = productCategoryService.findAllByIdIn(categoryIds);
        List<Integer> retrievedCategoryIds = categoryList.stream().map(ProductCategory::getId).toList();
        categoryIds.forEach(categoryId -> {
            if (!retrievedCategoryIds.contains(categoryId)) {
                throw new CustomBadRequestException(String.format("Category ID: %s  does not exist.", categoryId));
            }
        });
        return categoryList;
    }
}
