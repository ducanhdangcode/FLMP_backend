package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.MarketValueDto;
import net.ducanh.flmp_backend.service.MarketValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/marketValues")
public class MarketValueController {
    private MarketValueService marketValueService;

    @PostMapping
    public ResponseEntity<MarketValueDto> createMarketValue(@RequestBody MarketValueDto marketValueDto) {
        MarketValueDto savedMarketValue = marketValueService.createMarketValue(marketValueDto);
        return new ResponseEntity<>(savedMarketValue, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MarketValueDto>> getAllMarketValues() {
        List<MarketValueDto> marketValues = marketValueService.getAllMarketValues();
        return ResponseEntity.ok(marketValues);
    }

    @GetMapping("{id}")
    public ResponseEntity<MarketValueDto> getMarketValueById (@PathVariable("id") Long marketValueId) {
        MarketValueDto marketValueDto = marketValueService.getMarketValueById(marketValueId);
        return ResponseEntity.ok(marketValueDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<MarketValueDto> updateMarketValue (@PathVariable("id") Long marketValueId, @RequestBody MarketValueDto updatedMarketValue) {
        MarketValueDto marketValueDto = marketValueService.updateMarketValue(marketValueId, updatedMarketValue);
        return ResponseEntity.ok(marketValueDto);
    }
}
