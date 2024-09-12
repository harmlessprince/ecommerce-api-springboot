package com.harmlessprince.ecommerceApi.product;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Storage Capacity, Color, Size
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

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
