package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.MarketValueDto;
import net.ducanh.flmp_backend.entity.MarketValue;

public class MarketValueMappers {
    public static MarketValueDto mapToMarketValueDto (MarketValue marketValue) {
        return new MarketValueDto (
                marketValue.getId(),
                marketValue.getTeamId(),
                marketValue.getTotal(),
                marketValue.getPositionBasedMarketValue(),
                marketValue.getTimeBasedMarketValue()
        );
    }

    public static MarketValue mapToMarketValue (MarketValueDto marketValueDto) {
        return new MarketValue (
                marketValueDto.getId(),
                marketValueDto.getTeamId(),
                marketValueDto.getTotal(),
                marketValueDto.getPositionBasedMarketValue(),
                marketValueDto.getTimeBasedMarketValue()
        );
    }
}
