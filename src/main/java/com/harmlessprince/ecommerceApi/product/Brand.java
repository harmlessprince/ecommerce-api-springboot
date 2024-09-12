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
        name = "brands"
)
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Storage LG, Hisense
    @Column(nullable = false, unique = true)
    private String name;

    private String logo;

    @Column(nullable = false, unique = true)
    private String slug;

    @PrePersist
    public void onPrePersist() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
    @PreUpdate
    public void onPreUpdate() {
        this.setSlug(name.toLowerCase().replace(" ", "_").replace("-", "_"));
    }
}
