package com.harmlessprince.ecommerceApi.product;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(
        name = "categories",
        indexes = {
                @Index(name = "idx_parent_id", columnList = "parent_id")
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column()
    private Integer parentId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @ManyToMany(mappedBy = "productCategories")
    private Set<Product> products;

    @PrePersist
    public void onPrePersist() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
    @PreUpdate
    public void onPreUpdate() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
}
