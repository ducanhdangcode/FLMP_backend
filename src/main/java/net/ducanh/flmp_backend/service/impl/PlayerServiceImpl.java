package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.*;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailPlayerMarketValue;
import net.ducanh.flmp_backend.entity.Player;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.PlayerMappers;
import net.ducanh.flmp_backend.repository.PlayerRepository;
import net.ducanh.flmp_backend.service.IPlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements IPlayerService {
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
        player.setStats(updatedPlayer.getStats());
        player.setPlayerRatings(updatedPlayer.getPlayerRatings());
        player.setPriorityPositions(updatedPlayer.getPriorityPositions());
        player.setTransfers(updatedPlayer.getTransfers());
        player.setYouthClubs(updatedPlayer.getYouthClubs());
        player.setRumours(updatedPlayer.getRumours());

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
        player.setStats(updatedPlayer.getStats());
        player.setPlayerRatings(updatedPlayer.getPlayerRatings());
        player.setPriorityPositions(updatedPlayer.getPriorityPositions());
        player.setTransfers(updatedPlayer.getTransfers());
        player.setYouthClubs(updatedPlayer.getYouthClubs());
        player.setRumours(updatedPlayer.getRumours());

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

    @Override
    public PlayerDto addPlayerStat (String playerName, PlayerStats stat) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerStats> stats = player.getStats();
        stats.add(stat);
        player.setStats(new ArrayList<>(stats));
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public List<PlayerStats> getStatBySeason(String playerName, String seasonName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerStats> stats = player.getStats().stream().filter(stat -> stat.getSeason().equals(seasonName)).collect(Collectors.toList());
        if (stats.isEmpty()) {
            throw new ResourceNotFoundException("Stats is not existed with the given season name: " + seasonName);
        }
        return stats;
    }

    @Override
    public PlayerStats getStatByLeague(String playerName, String leagueName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerStats> stats = player.getStats();
        return stats.stream().filter(stat -> stat.getLeagueName().equals(leagueName)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Stat is not existed with the given league name: " + leagueName)
        );
    }

    @Override
    public List<PlayerStats> getStatByTeam(String playerName, String teamName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerStats> stats =
                player.getStats().stream().filter(stat -> stat.getTeamName().equals(teamName)).collect(Collectors.toList());
        if (stats.isEmpty()) {
            throw new ResourceNotFoundException("Stats is not existed with the given team name: " + teamName);
        }
        return stats;
    }

    @Override
    public List<PlayerStats> getAllPlayerStats(String playerName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        return player.getStats();
    }

    @Override
    public PlayerDto addPlayerRating(String playerName, PlayerDetailRating playerRating) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        List<PlayerDetailRating> ratings = player.getPlayerRatings();
        ratings.add(playerRating);
        player.setPlayerRatings(new ArrayList<>(ratings));
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayerRatings(String playerName, List<PlayerDetailRating> playerRatings) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setPlayerRatings(playerRatings);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayerPriorityPositions(String playerName, List<PlayerPriorityPosition> priorityPositions) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setPriorityPositions(priorityPositions);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public List<DetailTransfer> getPlayerTransfers(String playerName) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        return player.getTransfers();
    }

    @Override
    public PlayerDto updatePlayerYouthClubs(String playerName, List<DetailYouthClub> youthClubs) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setYouthClubs(youthClubs);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayerMarketValues(String playerName, List<DetailPlayerMarketValue> personalMarketValues) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setPersonalMarketValues(personalMarketValues);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayerRumours(String playerName, List<DetailRumour> rumours) {
        Player player = playerRepository.findByName(playerName).orElseThrow(
                () -> new ResourceNotFoundException("Player is not existed with the given name: " + playerName)
        );
        player.setRumours(rumours);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMappers.mapToPlayerDto(savedPlayer);
    }
}
