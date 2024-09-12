package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.ProductImage;
import com.harmlessprince.ecommerceApi.product.requests.ProductImageRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductImageMapper implements IMapper<ProductImage, ProductImageResponse, ProductImageRequest> {
    @Override
    public ProductImageResponse fromEntity(ProductImage entity) {
        return new ProductImageResponse(
                entity.getId(),
                entity.getImageUrl()
        );
    }

    @Override
    public ProductImage toEntity(ProductImageRequest request) {
        return ProductImage
                .builder()
                .id(request.id())
                .imageUrl(request.imageUrl())
                .product(request.product())
                .build();
    }

    @Override
    public List<ProductImageResponse> fromEntityList(List<ProductImage> entities) {
        return List.of();
    }
}
