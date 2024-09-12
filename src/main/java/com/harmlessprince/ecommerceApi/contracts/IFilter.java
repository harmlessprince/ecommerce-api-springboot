package com.harmlessprince.ecommerceApi.contracts;
import org.springframework.data.jpa.domain.Specification;
import java.util.Map;

public interface IFilter <M>{
    Specification<M> applyFilter(Map<String, Object> queryParams);
}
