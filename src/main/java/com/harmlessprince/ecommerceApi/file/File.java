package com.harmlessprince.ecommerceApi.file;

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
@Table(name = "files",  indexes = {
        @Index(name = "idx_ownerId", columnList = "ownerId"),
        @Index(name = "idx_ownerType", columnList = "ownerType"),
        @Index(name = "idx_ownerIdOwnerType", columnList = "ownerId, ownerType")
})
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String ownerType;

    @Column()
    private Integer ownerId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String mimeType;

    @Column(nullable = false)
    private String url;

    @Column(nullable = true)
    private String customId;

    @Column(nullable = false)
    private String provider = "cloudinary";

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE", nullable = false)
    private Boolean status = true;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
