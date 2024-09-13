package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.ProductCategory;
import com.harmlessprince.ecommerceApi.product.requests.ProductCategoryRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductCategoryMapper implements IMapper<ProductCategory, ProductCategoryResponse, ProductCategoryRequest> {
    @Override
    public ProductCategoryResponse fromEntity(ProductCategory entity) {
        return new ProductCategoryResponse(entity.getId(), entity.getName(), entity.getSlug());
    }

    @Override
    public ProductCategory toEntity(ProductCategoryRequest request) {
        return ProductCategory.builder().id(request.id()).name(request.name()).parentId(request.parentId()).build();
    }

    @Override
    public List<ProductCategoryResponse> fromEntityList(List<ProductCategory> entities) {
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
