package com.harmlessprince.ecommerceApi.product;

import com.harmlessprince.ecommerceApi.brand.BrandMapper;
import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryMapper;
import com.harmlessprince.ecommerceApi.productImage.ProductImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductMapper implements IMapper<Product, ProductResponse, ProductRequest> {
    private final BrandMapper brandMapper;
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductImageMapper productImageMapper;

    @Override
    public ProductResponse fromEntity(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImageUrl(),
                brandMapper.fromEntity(entity.getBrand()),
                entity.getProductCategories().stream().map(productCategoryMapper::fromEntity).collect(Collectors.toSet()),
                productImageMapper.fromEntityList(entity.getProductImages().stream().toList())
        );
    }

    @Override
    public Product toEntity(ProductRequest request) {
        return Product
                .builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .build();
    }
    public Product toEntityForUpdate(UpdateProductRequest request, Product entity) {
        entity.setName(Optional.ofNullable(request.name()).orElse(entity.getName()) );
        entity.setDescription(Optional.ofNullable(request.description()).orElse(entity.getDescription()) );
        entity.setImageUrl(Optional.ofNullable(request.imageUrl()).orElse(entity.getImageUrl()) );
        return entity;
    }

    @Override
    public List<ProductResponse> fromEntityList(List<Product> entities) {
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
