package com.harmlessprince.ecommerceApi.product;

import com.harmlessprince.ecommerceApi.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIdIn(Set<Integer> ids);

    Boolean existsByNameAndBrandId(String name, Integer brandId);

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END
            FROM Product p
            WHERE p.name = :name AND p.brand = :brand AND p.id <> :productId
            """)
    Boolean existsByNameAndBrandIdAndExemptProductId(@Param("name") String name, @Param("brand") Brand brand, @Param("productId") Integer productId);

    @Query("SELECT p FROM Product p JOIN FETCH p.brand JOIN FETCH p.productCategories JOIN FETCH p.productImages")
    List<Product> findAllProducts();

    @Query("""
            SELECT p FROM Product p
            JOIN FETCH p.brand
            JOIN FETCH p.productCategories
            JOIN FETCH p.productImages
            where p.id = :id
            """)
    Optional<Product> findByIdWithRelations(Integer id);
    @Query("""
            SELECT p FROM Product p
            JOIN FETCH p.brand
            where p.id = :id
            """)
    Optional<Product> findByIdWithBrand(Integer id);
}