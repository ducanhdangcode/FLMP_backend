package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    PlayerDto createPlayer(PlayerDto playerDto);

    List<PlayerDto> getAllPlayers();

    PlayerDto updatePlayer(Long playerId, PlayerDto updatedPlayer);

    PlayerDto getPlayerById (Long playerId);
}
