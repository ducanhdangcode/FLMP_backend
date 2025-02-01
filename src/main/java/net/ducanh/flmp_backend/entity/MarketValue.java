package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketValues")
public class MarketValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private String total;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "position_based")
    private List<Double> positionBased;

    @Column(name = "time_based")
    private List<Double> timeBased;
}
