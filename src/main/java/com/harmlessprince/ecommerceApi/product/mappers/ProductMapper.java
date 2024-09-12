package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.Product;
import com.harmlessprince.ecommerceApi.product.requests.ProductRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductMapper implements IMapper<Product, ProductResponse, ProductRequest> {
    private final BrandMapper brandMapper;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductResponse fromEntity(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImageUrl(),
                brandMapper.fromEntity(entity.getBrand()),
                entity.getProductCategories().stream().map(productCategoryMapper::fromEntity).collect(Collectors.toSet())
        );
    }

    @Override
    public Product toEntity(ProductRequest request) {
        return Product
                .builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .imageUrl(request.imageUrl())
                .brand(request.brand())
                .productCategories(request.productCategories())
                .build();
    }

    @Override
    public List<ProductResponse> fromEntityList(List<Product> entities) {
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
