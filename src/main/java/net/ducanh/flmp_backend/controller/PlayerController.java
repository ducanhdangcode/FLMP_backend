package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerContract;
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
}
