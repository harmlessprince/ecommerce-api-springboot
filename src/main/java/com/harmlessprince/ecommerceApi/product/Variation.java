package com.harmlessprince.ecommerceApi.product;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(
        name = "variations"
)
@NoArgsConstructor
@AllArgsConstructor
public class Variation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Storage Capacity, Color, Size
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    // a category of mobile phone may have variation of color, storage capacity and screen size (1, 3, colour, size)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;



    @PrePersist
    public void onPrePersist() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
    @PreUpdate
    public void onPreUpdate() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
}
