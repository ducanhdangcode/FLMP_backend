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

    @Column(name = "teamId", nullable = false)
    private int teamId;

    @Column(name = "total")
    private Long total;

    @Column(name = "position_based")
    private List<Long> positionBasedMarketValue;

    @Column(name = "time_based")
    private List<Long> timeBasedMarketValue;
}
