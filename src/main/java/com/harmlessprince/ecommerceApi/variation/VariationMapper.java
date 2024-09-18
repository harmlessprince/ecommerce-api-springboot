package com.harmlessprince.ecommerceApi.variation;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.productCategory.ProductCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Component
public class VariationMapper implements IMapper<Variation, VariationResponse, VariationRequest> {
    private final ProductCategoryMapper productCategoryMapper;
    @Override
    public VariationResponse fromEntity(Variation entity) {
        return new VariationResponse(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                productCategoryMapper.fromEntity(entity.getProductCategory())
        );
    }

    @Override
    public Variation toEntity(VariationRequest request) {
        return Variation.builder().id(request.id()).name(request.name()).productCategory(request.productCategory()).build();
    }

    public List<VariationResponse> fromEntityList(List<Variation> entities) {
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
