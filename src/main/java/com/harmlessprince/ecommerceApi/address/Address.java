package com.harmlessprince.ecommerceApi.address;

import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import com.harmlessprince.ecommerceApi.state.State;
import com.harmlessprince.ecommerceApi.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.NumericBooleanConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;

    @Column(nullable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isDefault = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "local_government_id")
    private LocalGovernment localGovernment;
}
