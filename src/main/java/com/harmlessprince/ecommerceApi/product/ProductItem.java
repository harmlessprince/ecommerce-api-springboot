package com.harmlessprince.ecommerceApi.product;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(
        name = "product_items"
)
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sku;

    private Integer quantityInStock;

//    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

//    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    @Column(precision = 10, scale = 2)
    private BigDecimal salePrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_item_variations",
            joinColumns = @JoinColumn(name = "product_item_id"),
            inverseJoinColumns = @JoinColumn(name = "variation_option_id")
    )
    private Set<VariationOption> variationOptions;

}
