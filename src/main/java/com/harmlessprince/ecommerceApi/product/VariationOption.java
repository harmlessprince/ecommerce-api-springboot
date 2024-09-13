package com.harmlessprince.ecommerceApi.product;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(
        name = "variation_options"
)
@NoArgsConstructor
@AllArgsConstructor
public class VariationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //grey, black, dark and blue,  XS, S,  M, L, XL
    private String value;

    @Column(nullable = false, unique = true)
    private String slug;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    // a size variation may have XS, S,  M, L, XL
    // a color variation may have grey, black, dark and blue
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "variation_id")
    private Variation variation;

//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "variationOptions"
//    )
//    private Set<ProductItem> productItem = new HashSet<>();

    @PrePersist
    public void onPrePersist() {
        this.setSlug(value.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
    @PreUpdate
    public void onPreUpdate() {
        this.setSlug(value.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
}
