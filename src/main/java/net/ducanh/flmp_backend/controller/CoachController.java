package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachContract;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachStat;
import net.ducanh.flmp_backend.entity.CustomEntity.GroupedCoachStatByCompetition;
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

    @GetMapping("get-by-name/{coach-name}")
    public ResponseEntity<CoachDto> getCoachByName (@PathVariable("coach-name") String coachName) {
        CoachDto coachDto = coachService.getCoachByCoachName(coachName);
        return ResponseEntity.ok(coachDto);
    }

    @PostMapping("{coach-name}/add-contract")
    public ResponseEntity<CoachDto> addCoachContract (@PathVariable("coach-name") String coachName,
                                                      @RequestBody DetailCoachContract contract) {
        CoachDto coachDto = coachService.addCoachContract(coachName, contract);
        return ResponseEntity.ok(coachDto);
    }

    @GetMapping("{coach-name}/get-contract-by-team-name/{team-name}")
    public ResponseEntity<DetailCoachContract> getContractByTeamName (@PathVariable("coach-name") String coachName,
                                                                  @PathVariable("team-name") String teamName) {
        DetailCoachContract contract = coachService.getContractByTeamName(coachName, teamName);
        return ResponseEntity.ok(contract);
    }

    @GetMapping("{coach-name}/get-grouped-stats-by-competition")
    public ResponseEntity<List<GroupedCoachStatByCompetition>> getGroupedCoachStatsByCompetition (@PathVariable(
            "coach-name") String coachName) {
        List<GroupedCoachStatByCompetition> groupedStats = coachService.getGroupedCoachStatByCompetition(coachName);
        return ResponseEntity.ok(groupedStats);
    }

    @PostMapping("{coach-name}/add-coach-stat")
    public ResponseEntity<CoachDto> addCoachStat (@PathVariable("coach-name") String coachName,
                                                  @RequestBody DetailCoachStat stat) {
        CoachDto coachDto = coachService.addCoachStats(coachName, stat);
        return ResponseEntity.ok(coachDto);
    }

    @GetMapping("{coach-name}/get-coach-stats-by-competition-name/{competition-name}")
    public ResponseEntity<List<DetailCoachStat>> getCoachStatsByCompetitionName (@PathVariable("coach-name") String coachName, @PathVariable("competition-name") String competitionName) {
        List<DetailCoachStat> detailCoachStats = coachService.getCoachStatsByCompetitionName(coachName,
                competitionName);
        return ResponseEntity.ok(detailCoachStats);
    }

    @PutMapping("{coach-name}/update-coach-stats")
    public ResponseEntity<CoachDto> updateCoachDetailStats (@PathVariable("coach-name") String coachName,
                                                            @RequestBody List<DetailCoachStat> stats) {
        CoachDto coachDto = coachService.updateDetailCoachStats(coachName, stats);
        return ResponseEntity.ok(coachDto);
    }
}
