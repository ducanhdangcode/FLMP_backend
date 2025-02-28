package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerContract;
import net.ducanh.flmp_backend.entity.Player;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.PlayerMappers;
import net.ducanh.flmp_backend.repository.PlayerRepository;
import net.ducanh.flmp_backend.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        player.setBirthPlace(updatedPlayer.getBirthPlace());
        player.setHeight(updatedPlayer.getHeight());
        player.setBirthDate(updatedPlayer.getBirthDate());
        player.setMarketValue(updatedPlayer.getMarketValue());
        player.setTeam(updatedPlayer.getTeam());
        player.setTeamId(updatedPlayer.getTeamId());
        player.setPosition(updatedPlayer.getPosition());
        player.setDetailPosition(updatedPlayer.getDetailPosition());
        player.setOtherPosition(updatedPlayer.getOtherPosition());
        player.setGoalQuantity(updatedPlayer.getGoalQuantity());
        player.setImageLink(updatedPlayer.getImageLink());
        player.setAppearances(updatedPlayer.getAppearances());
        player.setCleanSheets(updatedPlayer.getCleanSheets());
        player.setGoalConceded(updatedPlayer.getGoalConceded());
        player.setSaves(updatedPlayer.getSaves());
        player.setAssist(updatedPlayer.getAssist());
        player.setMinutePlayed(updatedPlayer.getMinutePlayed());
        player.setNationalityImageLink(updatedPlayer.getNationalityImageLink());
        player.setFormerInternational(updatedPlayer.getFormerInternational());
        player.setPreferredFoot(updatedPlayer.getPreferredFoot());
        player.setContracts(updatedPlayer.getContracts());

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

    @Override
    public PlayerDto getPlayerByName(String playerName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        return PlayerMappers.mapToPlayerDto(player);
    }

    @Override
    public PlayerDto updatePlayerByName(String playerName, PlayerDto updatedPlayer) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setName(updatedPlayer.getName());
        player.setNationality(updatedPlayer.getNationality());
        player.setBirthPlace(updatedPlayer.getBirthPlace());
        player.setHeight(updatedPlayer.getHeight());
        player.setBirthDate(updatedPlayer.getBirthDate());
        player.setMarketValue(updatedPlayer.getMarketValue());
        player.setTeam(updatedPlayer.getTeam());
        player.setTeamId(updatedPlayer.getTeamId());
        player.setPosition(updatedPlayer.getPosition());
        player.setDetailPosition(updatedPlayer.getDetailPosition());
        player.setOtherPosition(updatedPlayer.getOtherPosition());
        player.setGoalQuantity(updatedPlayer.getGoalQuantity());
        player.setImageLink(updatedPlayer.getImageLink());
        player.setAppearances(updatedPlayer.getAppearances());
        player.setCleanSheets(updatedPlayer.getCleanSheets());
        player.setGoalConceded(updatedPlayer.getGoalConceded());
        player.setSaves(updatedPlayer.getSaves());
        player.setAssist(updatedPlayer.getAssist());
        player.setMinutePlayed(updatedPlayer.getMinutePlayed());
        player.setNationalityImageLink(updatedPlayer.getNationalityImageLink());
        player.setFormerInternational(updatedPlayer.getFormerInternational());
        player.setPreferredFoot(updatedPlayer.getPreferredFoot());
        player.setContracts(updatedPlayer.getContracts());

        Player updatedPlayerObj = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(updatedPlayerObj);
    }

    @Override
    public PlayerDto addPlayerContract(String playerName, PlayerContract contract) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerContract> contracts = player.getContracts();
        contracts.add(contract);
        player.setContracts(new ArrayList<>(contracts));
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerContract getPlayerContractByTeamName(String playerName, String teamName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerContract> contracts = player.getContracts();
        return contracts.stream().filter(contract -> contract.getTeamName().equals(teamName)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Contract is not found with the given team name: " + teamName)
        );
    }
}
