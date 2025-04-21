package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.entity.CustomEntity.*;
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

    @GetMapping("{coach-name}/get-grouped-stats-by-competition/{league-type}")
    public ResponseEntity<List<GroupedCoachStatByCompetition>> getGroupedCoachStatsByCompetition (@PathVariable(
            "coach-name") String coachName, @PathVariable("league-type") String leagueType) {
        List<GroupedCoachStatByCompetition> groupedStats = coachService.getGroupedCoachStatByCompetition(coachName,
                leagueType);
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

    @GetMapping("{coach-name}/get-coach-stats-by-league-type/{league-type}")
    public ResponseEntity<List<DetailCoachStat>> getCoachStatsByLeagueType (@PathVariable("coach-name") String coachName, @PathVariable("league-type") String leagueType) {
        List<DetailCoachStat> detailCoachStats = coachService.getCoachStatsByLeagueType(coachName, leagueType);
        return ResponseEntity.ok(detailCoachStats);
    }

    @PostMapping("{coach-name}/add-coach-history")
    public ResponseEntity<CoachDto> addCoachHistory (@PathVariable("coach-name") String coachName,
                                                     @RequestBody DetailCoachHistory history) {
        CoachDto coachDto = coachService.addCoachHistory(coachName, history);
        return ResponseEntity.ok(coachDto);
    }

    @PostMapping("{coach-name}/add-record-against-club")
    public ResponseEntity<CoachDto> addRecordAgainstClub (@PathVariable("coach-name") String coachName,
                                                          @RequestBody DetailCoachRecordAgainstClub record) {
        CoachDto coachDto = coachService.addCoachRecordAgainstClub(coachName, record);
        return ResponseEntity.ok(coachDto);
    }

    @PostMapping("{coach-name}/add-record-against-manager")
    public ResponseEntity<CoachDto> addRecordAgainstManager (@PathVariable("coach-name") String coachName,
                                                             @RequestBody DetailCoachRecordAgainstManager record) {
        CoachDto coachDto = coachService.addCoachRecordAgainstManager(coachName, record);
        return ResponseEntity.ok(coachDto);
    }

    @PostMapping("{coach-name}/add-debut-career")
    public ResponseEntity<CoachDto> addCoachDebutCareer (@PathVariable("coach-name") String coachName,
                                                         @RequestBody DetailCoachDebutCareer career) {
        CoachDto coachDto = coachService.addCoachDebutCareer(coachName, career);
        return ResponseEntity.ok(coachDto);
    }

    @PostMapping("{coach-name}/add-special-match-career")
    public ResponseEntity<CoachDto> addCoachSpecialMatchCareer (@PathVariable("coach-name") String coachName,
                                                                @RequestBody DetailCoachSpecialMatchCareer career) {
        CoachDto coachDto = coachService.addCoachSpecialMatchCareer(coachName, career);
        return ResponseEntity.ok(coachDto);
    }
}
