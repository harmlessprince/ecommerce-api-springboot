package com.harmlessprince.ecommerceApi.lga;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harmlessprince.ecommerceApi.state.State;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Setter
@Getter
@Table(name = "local_governments")
@NoArgsConstructor
@AllArgsConstructor
public class LocalGovernment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private State state;
}
