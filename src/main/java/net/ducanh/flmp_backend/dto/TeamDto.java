package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private long id;
    private String logo;
    private String name;
    private String color;
    private List<Integer> trophies;
    private String stadium;
    private String StadiumTotalSeat;
    private String StadiumLocation;
    private String StadiumOpenDate;
    private String StadiumCost;
    private List<String> kitColors;
    private String chairmanName;
    private String chairmanDescription;
    private List<String> videoLinks;
    private String favoriteState;
    private String totalMarketValue;
    private List<Double> detailMarketValue;
    private List<Double> timeMarketValue;
}
