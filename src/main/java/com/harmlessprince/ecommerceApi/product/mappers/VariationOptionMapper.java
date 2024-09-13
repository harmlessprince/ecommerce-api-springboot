package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.VariationOption;
import com.harmlessprince.ecommerceApi.product.requests.VariationOptionRequest;
import com.harmlessprince.ecommerceApi.product.responses.VariationOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class VariationOptionMapper implements IMapper<VariationOption, VariationOptionResponse, VariationOptionRequest> {
    private final VariationMapper variationMapper;

    @Override
    public VariationOptionResponse fromEntity(VariationOption entity) {
        return new VariationOptionResponse(entity.getId(), entity.getValue(), entity.getSlug(), variationMapper.fromEntity(entity.getVariation()));
    }

    @Override
    public VariationOption toEntity(VariationOptionRequest request) {
        return VariationOption.builder().id(request.id()).value(request.value()).variation(request.variation()).build();
    }

    @Override
    public List<VariationOptionResponse> fromEntityList(List<VariationOption> entities) {
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
