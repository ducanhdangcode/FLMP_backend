package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketValueDto {
    private Long id;
    private int teamId;
    private Long total;
    private List<Long> positionBasedMarketValue;
    private List<Long> timeBasedMarketValue;
}
