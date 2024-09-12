package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.ProductItem;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import com.harmlessprince.ecommerceApi.product.requests.ProductItemRequest;
import com.harmlessprince.ecommerceApi.product.responses.ProductItemResponse;
import com.harmlessprince.ecommerceApi.product.responses.VariationOptionResponse;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductItemMapper implements IMapper<ProductItem, ProductItemResponse, ProductItemRequest> {
    private final VariationOptionMapper variationOptionMapper;
    private final ProductMapper productMapper;

    @Override
    public ProductItemResponse fromEntity(ProductItem entity) {
        return new ProductItemResponse(
                entity.getId(),
                entity.getSku(),
                entity.getQuantityInStock(),
                entity.getPrice(),
                entity.getSalePrice(),
                productMapper.fromEntity(entity.getProduct()),
                entity.getVariationOptions().stream().map(variationOptionMapper::fromEntity).collect(Collectors.toSet())
        );
    }

    @Override
    public ProductItem toEntity(ProductItemRequest request) {
        return ProductItem
                .builder()
                .id(request.id())
                .price(request.price())
                .salePrice(request.salePrice())
                .quantityInStock(request.quantityInStock())
                .product(request.product())
                .variationOptions(request.variationOptions())
                .build();
    }

    @Override
    public List<ProductItemResponse> fromEntityList(List<ProductItem> entities) {
        return List.of();
    }
}
