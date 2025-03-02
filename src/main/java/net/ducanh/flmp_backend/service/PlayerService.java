package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerContract;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerStats;

import java.util.List;

public interface PlayerService {
    PlayerDto createPlayer(PlayerDto playerDto);

    List<PlayerDto> getAllPlayers();

    PlayerDto updatePlayer(Long playerId, PlayerDto updatedPlayer);

    PlayerDto getPlayerById (Long playerId);

    PlayerDto getPlayerByName (String playerName);

    PlayerDto updatePlayerByName (String playerName, PlayerDto updatedPlayer);

    PlayerDto addPlayerContract (String playerName, PlayerContract contract);

    PlayerContract getPlayerContractByTeamName (String playerName, String teamName);

    PlayerDto addPlayerStat (String playerName, PlayerStats stat);

    List<PlayerStats> getStatBySeason (String playerName, String seasonName);

    PlayerStats getStatByLeague (String playerName, String leagueName);

    PlayerStats getStatByTeam (String playerName, String teamName);
}
