package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.CustomEntity.*;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailPlayerMarketValue;

import java.util.List;

public interface IPlayerService {
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

    List<PlayerStats> getStatByTeam (String playerName, String teamName);

    List<PlayerStats> getAllPlayerStats (String playerName);

    PlayerDto addPlayerRating (String playerName, PlayerDetailRating playerRating);

    PlayerDto updatePlayerRatings (String playerName, List<PlayerDetailRating> playerRatings);

    PlayerDto updatePlayerPriorityPositions (String playerName, List<PlayerPriorityPosition> priorityPositions);

    List<DetailTransfer> getPlayerTransfers (String playerName);

    PlayerDto addPlayerTransfers (String playerName, DetailTransfer transfer);

    PlayerDto updatePlayerYouthClubs (String playerName, List<DetailYouthClub> youthClubs);

    PlayerDto updatePlayerMarketValues (String playerName, List<DetailPlayerMarketValue> personalMarketValues);

    PlayerDto updatePlayerRumours (String playerName, List<DetailRumour> rumours);

    PlayerDto updatePlayerNationalTeamStats (String playerName, List<DetailNationalTeamStat> nationalTeamStats);

    PlayerDto updatePlayerDetailMatchStats (String playerName, List<DetailMatchStats> detailMatchStats);

    PlayerDto addMatchStat (String playerName, DetailMatchStats matchStat);

    List<DetailMatchStats> getMatchStatByCompetition (String playerName, String competitionName);

    PlayerDto addPersonalDetailNews (String playerName, PersonalDetailNews personalDetailNew);

    String deletePersonalDetailNews (String playerName, int newsId);
}
