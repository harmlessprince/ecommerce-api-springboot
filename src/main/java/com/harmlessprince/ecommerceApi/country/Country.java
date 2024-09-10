package com.harmlessprince.ecommerceApi.country;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harmlessprince.ecommerceApi.state.State;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status = true;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<State> states;
}
