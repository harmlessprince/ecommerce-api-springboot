package com.harmlessprince.ecommerceApi.product.mappers;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.product.Brand;
import com.harmlessprince.ecommerceApi.product.requests.BrandRequest;
import com.harmlessprince.ecommerceApi.product.responses.BrandResponse;
import com.harmlessprince.ecommerceApi.product.services.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class BrandMapper implements IMapper<Brand, BrandResponse, BrandRequest> {
    private final BrandService brandService;

    @Override
    public BrandResponse fromEntity(Brand entity) {
        return new BrandResponse(entity.getId(), entity.getName(), entity.getLogo(), entity.getSlug());
    }

    @Override
    public Brand toEntity(BrandRequest request) {
        return Brand.builder().id(request.id()).name(request.name()).logo(request.logo()).build();
    }

    @Override
    public List<BrandResponse> fromEntityList(List<Brand> entities) {
        List<Brand> brands = brandService.findAll();
        return brands.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
