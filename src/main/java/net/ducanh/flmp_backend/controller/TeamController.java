package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;
import net.ducanh.flmp_backend.service.TeamService;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        TeamDto savedTeam = teamService.createTeam(teamDto);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Team>> getAllTeams (@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Page<Team> pagedTeam = teamService.getAllTeams(PageRequest.of(page, size));
        return ResponseEntity.ok(pagedTeam);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDto> getTeamById (@PathVariable("id") Long teamId) {
        TeamDto teamDto = teamService.getTeamById(teamId);
        return ResponseEntity.ok(teamDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable("id") Long teamId, @RequestBody TeamDto UpdatedTeam) {
        TeamDto teamDto = teamService.updateTeam(teamId, UpdatedTeam);
        return ResponseEntity.ok(teamDto);
    }

    @PutMapping("/{id}/update-favorite-state")
    public ResponseEntity<TeamDto> updateFavoriteState(@PathVariable("id") Long teamId,
                                                       @RequestBody String favoriteState) {
        TeamDto teamDto = teamService.updateFavoriteState(teamId, favoriteState);
        return ResponseEntity.ok(teamDto);
    }

    @GetMapping("/get-by-name/{team-name}")
    public ResponseEntity<TeamDto> getTeamByTeamName (@PathVariable("team-name") String teamName) {
        TeamDto teamDto = teamService.getTeamByTeamName(teamName);
        return ResponseEntity.ok(teamDto);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteTeamById (@PathVariable("id") Long teamId) {
        String responseString = teamService.deleteTeamById(teamId);
        return ResponseEntity.ok(responseString);
    }
}
