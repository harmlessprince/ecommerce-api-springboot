package com.harmlessprince.ecommerceApi.bases;
import com.harmlessprince.ecommerceApi.contracts.IFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Method;
import java.util.Map;
@Slf4j
public abstract class BaseFilter<M> implements IFilter<M> {

    public Specification<M> filterByName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
    @Override
    public Specification<M> applyFilter(Map<String, Object> queryParams) {
        Specification<M> specification = Specification.where(null);
        for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
            String key = queryParam.getKey();
            Object value = queryParam.getValue();
            try {
                Method method = this.findMethodInFilterClass( key, value);
                if (method != null) {
                    Specification<M> filterSpec = (Specification<M>) method.invoke(this, value);
                    specification = specification.and(filterSpec);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return specification;
            }
        }
        return specification;
    }

    private Method findMethodInFilterClass(String filterKey, Object filterValue) {
        // Convert the filterKey to a method name, e.g., "category" -> "filterByCategory"
        String methodName = "filterBy" + filterKey.substring(0, 1).toUpperCase() + filterKey.substring(1);
        log.info(filterValue.getClass().getSimpleName());
        try {
            return this.getClass().getMethod(methodName, filterValue.getClass());
        } catch (NoSuchMethodException e) {
            log.info("No such method {}", methodName);
            return null;
        }
    }
    protected static int safeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            log.info("Invalid integer: {}", str);
            return 0;
        }
    }
}
