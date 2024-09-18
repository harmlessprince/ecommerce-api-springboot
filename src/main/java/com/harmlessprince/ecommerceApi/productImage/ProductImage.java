package com.harmlessprince.ecommerceApi.productImage;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harmlessprince.ecommerceApi.file.File;
import com.harmlessprince.ecommerceApi.product.Product;
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
        name = "product_images"
)
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    public static final String MORPH = "product_image";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private File file;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private Product product;

//    @Column()
//    private Integer productId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
