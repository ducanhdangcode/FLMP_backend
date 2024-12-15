package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.Player;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.PlayerMappers;
import net.ducanh.flmp_backend.repository.PlayerRepository;
import net.ducanh.flmp_backend.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = PlayerMappers.mapToPlayer(playerDto);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map((player) -> PlayerMappers.mapToPlayerDto(player)).collect(Collectors.toList());
    }

    @Override
    public PlayerDto updatePlayer(Long playerId, PlayerDto updatedPlayer) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given id: " + playerId)
        );
        player.setName(updatedPlayer.getName());
        player.setNationality(updatedPlayer.getNationality());
        player.setHeight(updatedPlayer.getHeight());
        player.setWeight(updatedPlayer.getWeight());
        player.setBirthDate(updatedPlayer.getBirthDate());
        player.setMarketValue(updatedPlayer.getMarketValue());
        player.setTeam(updatedPlayer.getTeam());
        player.setTeamId(updatedPlayer.getTeamId());
        player.setPosition(updatedPlayer.getPosition());
        player.setGoalQuantity(updatedPlayer.getGoalQuantity());
        player.setImageLink(updatedPlayer.getImageLink());
        player.setAppearances(updatedPlayer.getAppearances());
        player.setCleanSheets(updatedPlayer.getCleanSheets());
        player.setGoalConceded(updatedPlayer.getGoalConceded());
        player.setSaves(updatedPlayer.getSaves());
        player.setAssist(updatedPlayer.getAssist());
        player.setMinutePlayed(updatedPlayer.getMinutePlayed());
        player.setNationalityImageLink(updatedPlayer.getNationalityImageLink());

        Player updatedPlayerObj = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(updatedPlayerObj);
    }

    @Override
    public PlayerDto getPlayerById(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given id: " + playerId)
        );
        return PlayerMappers.mapToPlayerDto(player);
    }
}
