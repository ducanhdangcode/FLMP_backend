package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.MarketValueDto;
import net.ducanh.flmp_backend.entity.MarketValue;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.MarketValueMappers;
import net.ducanh.flmp_backend.repository.MarketValueRepository;
import net.ducanh.flmp_backend.service.MarketValueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MarketValueServiceImpl implements MarketValueService {
    private MarketValueRepository marketValueRepository;
    @Override
    public MarketValueDto createMarketValue(MarketValueDto marketValueDto) {
        MarketValue marketValue = MarketValueMappers.mapToMarketValue(marketValueDto);
        MarketValue savedMarketValue = marketValueRepository.save(marketValue);
        return MarketValueMappers.mapToMarketValueDto(savedMarketValue);
    }

    @Override
    public List<MarketValueDto> getAllMarketValues() {
        List<MarketValue> marketValues = marketValueRepository.findAll();
        return marketValues.stream().map((marketValue) -> MarketValueMappers.mapToMarketValueDto(marketValue)).collect(Collectors.toList());
    }

    @Override
    public MarketValueDto getMarketValueById(Long marketValueId) {
        MarketValue marketValue = marketValueRepository.findById(marketValueId).orElseThrow(
                () -> new ResourceNotFoundException("Market value is not existed!")
        );
        return MarketValueMappers.mapToMarketValueDto(marketValue);
    }

    @Override
    public MarketValueDto updateMarketValue(Long marketValueId, MarketValueDto updatedMarketValue) {
        MarketValue marketValue = marketValueRepository.findById(marketValueId).orElseThrow(
                () -> new ResourceNotFoundException("Market value is not existed")
        );
        marketValue.setTotal(updatedMarketValue.getTotal());
        marketValue.setTeamName(updatedMarketValue.getTeamName());
        marketValue.setPositionBased(updatedMarketValue.getPositionBased());
        marketValue.setTimeBased(updatedMarketValue.getTimeBased());

        MarketValue updatedMarketValueObj = marketValueRepository.save(marketValue);
        return MarketValueMappers.mapToMarketValueDto(updatedMarketValueObj);
    }
}
