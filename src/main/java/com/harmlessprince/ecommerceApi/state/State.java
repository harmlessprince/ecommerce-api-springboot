package com.harmlessprince.ecommerceApi.state;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harmlessprince.ecommerceApi.address.Address;
import com.harmlessprince.ecommerceApi.country.Country;
import com.harmlessprince.ecommerceApi.lga.LocalGovernment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "states")
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;

//    @OneToMany(mappedBy = "state")
//    @JsonBackReference
//    private Set<LocalGovernment> localGovernments;

//    @OneToMany(mappedBy = "state")
//    @JsonBackReference
//    private Set<Address> addresses;
}
