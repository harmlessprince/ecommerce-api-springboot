package com.harmlessprince.ecommerceApi.contracts;

import java.util.List;

public interface IMapper<E, RES, REQ> {
    public RES fromEntity(E entity);

    public E toEntity(REQ request);

    public List<RES> fromEntityList(List<E> entities);

}
