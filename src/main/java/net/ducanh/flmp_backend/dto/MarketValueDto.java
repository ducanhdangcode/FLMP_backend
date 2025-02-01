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
    private String total;
    private String teamName;
    private List<Double> positionBased;
    private List<Double> timeBased;
}
