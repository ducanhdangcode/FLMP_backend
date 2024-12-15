package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "logo")
    private String logo;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "Trophies")
    private List<Integer> trophies;

    @Column(name = "Stadium")
    private String stadium;

    @Column(name = "Stadium-total-seat")
    private String StadiumTotalSeat;

    @Column(name = "Stadium-location")
    private String StadiumLocation;

    @Column(name = "Stadium-Date-Open")
    private String StadiumOpenDate;

    @Column(name = "Stadium-Cost")
    private String StadiumCost;

    @Column(name = "Kit-Color")
    private List<String> kitColors;

    @Column(name = "Chairman-name")
    private String chairmanName;

    @Column(name = "Chairman-description", columnDefinition = "TEXT", length = 10000000)
    private String chairmanDescription;

    @Column(name = "Video-links")
    private List<String> videoLinks;

    @Column(name = "Favorite-state")
    private String favoriteState;

    @Column(name = "Total-market-value")
    private String totalMarketValue;

    @Column(name = "Detail-market-value")
    private List<Double> detailMarketValue;

    @Column(name = "Time-market-value")
    private List<Double> timeMarketValue;
}
