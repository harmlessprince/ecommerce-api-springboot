package com.harmlessprince.ecommerceApi.contracts;

import com.harmlessprince.ecommerceApi.product.Variation;
import com.harmlessprince.ecommerceApi.product.responses.VariationResponse;

import java.util.List;

public interface IMapper<E, RES, REQ> {
    public RES fromEntity(E entity);

    public E toEntity(REQ request);

    public List<RES> fromEntityList(List<E> entities);
}
