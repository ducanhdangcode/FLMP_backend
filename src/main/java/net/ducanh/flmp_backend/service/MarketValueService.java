package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.MarketValueDto;

import java.util.List;

public interface MarketValueService {
    MarketValueDto createMarketValue (MarketValueDto marketValueDto);

    List<MarketValueDto> getAllMarketValues();

    MarketValueDto getMarketValueById (Long marketValueId);

    MarketValueDto updateMarketValue (Long marketValueId, MarketValueDto updatedMarketValue);
}
