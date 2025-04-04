package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.service.ICoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    private ICoachService coachService;

    @PostMapping
    public ResponseEntity<CoachDto> createCoach(@RequestBody CoachDto coachDto) {
        CoachDto savedCoach = coachService.createCoach(coachDto);
        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CoachDto>> getAllCoaches() {
        List<CoachDto> coaches = coachService.getAllCoaches();
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoachDto> getCoachById(@PathVariable("id") Long coachId) {
        CoachDto coachDto = coachService.getCoachById(coachId);
        return ResponseEntity.ok(coachDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CoachDto> updateCoach(@PathVariable("id") Long coachId, @RequestBody CoachDto UpdatedCoach) {
        CoachDto coachDto = coachService.updateCoach(coachId, UpdatedCoach);
        return ResponseEntity.ok(coachDto);
    }

    @GetMapping("get-by-team-name/{team-name}")
    public ResponseEntity<CoachDto> getCoachByTeamName (@PathVariable("team-name") String teamName) {
        CoachDto coachDto = coachService.getCoachByTeamName(teamName);
        return ResponseEntity.ok(coachDto);
    }
}
