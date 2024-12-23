package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.StadiumDto;
import net.ducanh.flmp_backend.entity.Stadium;
import net.ducanh.flmp_backend.service.StadiumService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {
    private StadiumService stadiumService;

    @PostMapping
    public ResponseEntity<StadiumDto> createStadium (@RequestBody StadiumDto stadiumDto) {
        StadiumDto savedStadium = stadiumService.createStadium(stadiumDto);
        return new ResponseEntity<>(savedStadium, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StadiumDto>> getAllStadiums () {
        List<StadiumDto> stadiums = stadiumService.getAllStadiums();
        return ResponseEntity.ok(stadiums);
    }

    @PutMapping("{id}")
    public ResponseEntity<StadiumDto> updateStadium (@PathVariable("id") Long stadiumId, @RequestBody StadiumDto UpdatedStadium) {
        StadiumDto stadiumDto = stadiumService.updateStadium(stadiumId, UpdatedStadium);
        return ResponseEntity.ok(stadiumDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<StadiumDto> getStadiumById (@PathVariable("id") Long stadiumId) {
        StadiumDto stadiumDto = stadiumService.getStadiumById(stadiumId);
        return ResponseEntity.ok(stadiumDto);
    }
}
