package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerContract;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerDetailRating;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerPriorityPosition;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerStats;
import net.ducanh.flmp_backend.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        PlayerDto savedPlayer = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long playerId) {
        PlayerDto playerDto = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable("id") Long playerId, @RequestBody PlayerDto UpdatedPlayer) {
        PlayerDto playerDto = playerService.updatePlayer(playerId, UpdatedPlayer);
        return ResponseEntity.ok(playerDto);
    }

    @GetMapping("/name/{player-name}")
    public ResponseEntity<PlayerDto> getPlayerByName (@PathVariable("player-name") String playerName) {
        PlayerDto playerDto = playerService.getPlayerByName(playerName);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping("/name/{player-name}")
    public ResponseEntity<PlayerDto> updatePlayerByName (@PathVariable("player-name") String playerName,
                                                         @RequestBody PlayerDto updatedPlayer) {
        PlayerDto playerDto = playerService.updatePlayerByName(playerName, updatedPlayer);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping("/name/{player-name}/add-contract")
    public ResponseEntity<PlayerDto> addPlayerContract (@PathVariable("player-name") String playerName,
                                                  @RequestBody PlayerContract contract) {
        PlayerDto playerDto = playerService.addPlayerContract(playerName, contract);
        return ResponseEntity.ok(playerDto);
    }

    @GetMapping("/name/{player-name}/find-contract/{teamName}")
    public ResponseEntity<PlayerContract> getPlayerContractByTeamName (@PathVariable("player-name") String playerName
            , @PathVariable("teamName") String teamName) {
        PlayerContract contract = playerService.getPlayerContractByTeamName(playerName, teamName);
        return ResponseEntity.ok(contract);
    }

    @PutMapping("/name/{player-name}/add-stat")
    public ResponseEntity<PlayerDto> addPlayerStat (@PathVariable("player-name") String playerName,
                                                    @RequestBody PlayerStats stat) {
        PlayerDto  playerDto = playerService.addPlayerStat(playerName, stat);
        return ResponseEntity.ok(playerDto);
    }

    @GetMapping("/name/{player-name}/get-stat-by-season/{season-name}")
    public ResponseEntity<List<PlayerStats>> getStatBySeason (@PathVariable("player-name") String playerName,
                                                        @PathVariable("season-name") String seasonName) {
        List<PlayerStats> stats = playerService.getStatBySeason(playerName, seasonName);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/name/{player-name}/get-stat-by-league/{league-name}")
    public ResponseEntity<PlayerStats> getStatByLeague (@PathVariable("player-name") String playerName,
                                                        @PathVariable("league-name") String leagueName) {
        PlayerStats stat = playerService.getStatByLeague(playerName, leagueName);
        return ResponseEntity.ok(stat);
    }

    @GetMapping("/name/{player-name}/get-stat-by-team/{team-name}")
    public ResponseEntity<List<PlayerStats>> getStatByTeam (@PathVariable("player-name") String playerName, @PathVariable(
            "team-name") String teamName) {
        List<PlayerStats> stats = playerService.getStatByTeam(playerName, teamName);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/name/{player-name}/get-all-stats")
    public ResponseEntity<List<PlayerStats>> getAllPlayerStats (@PathVariable("player-name") String playerName) {
        List<PlayerStats> stats = playerService.getAllPlayerStats(playerName);
        return ResponseEntity.ok(stats);
    }

    @PutMapping("/name/{player-name}/add-player-rating")
    public ResponseEntity<PlayerDto> addPlayerRating (@PathVariable("player-name") String playerName,
                                                      @RequestBody PlayerDetailRating playerRating) {
        PlayerDto playerDto = playerService.addPlayerRating(playerName, playerRating);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping("/name/{player-name}/update-player-ratings")
    public ResponseEntity<PlayerDto> updatePlayerRatings (@PathVariable("player-name") String playerName,
                                                          @RequestBody List<PlayerDetailRating> playerRatings) {
        PlayerDto playerDto = playerService.updatePlayerRatings(playerName, playerRatings);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping("/name/{player-name}/update-priority-positions")
    public ResponseEntity<PlayerDto> updatePlayerPriorityPositions (@PathVariable("player-name") String playerName,
                                                                    @RequestBody List<PlayerPriorityPosition> priorityPositions) {
        PlayerDto playerDto = playerService.updatePlayerPriorityPositions(playerName, priorityPositions);
        return ResponseEntity.ok(playerDto);
    }
}
