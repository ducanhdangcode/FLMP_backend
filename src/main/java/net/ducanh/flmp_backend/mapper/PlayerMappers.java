package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.Player;

public class PlayerMappers {
    public static PlayerDto mapToPlayerDto (Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getNationality(),
                player.getBirthPlace(),
                player.getHeight(),
                player.getBirthDate(),
                player.getMarketValue(),
                player.getTeam(),
                player.getTeamId(),
                player.getShirtNumber(),
                player.getPosition(),
                player.getDetailPosition(),
                player.getOtherPosition(),
                player.getGoalQuantity(),
                player.getImageLink(),
                player.getAppearances(),
                player.getCleanSheets(),
                player.getGoalConceded(),
                player.getSaves(),
                player.getAssist(),
                player.getMinutePlayed(),
                player.getNationalityImageLink(),
                player.getFormerInternational(),
                player.getPreferredFoot(),
                player.getContracts(),
                player.getStats(),
                player.getPlayerRatings(),
                player.getPriorityPositions(),
                player.getTransfers(),
                player.getYouthClubs(),
                player.getPersonalMarketValues(),
                player.getRumours(),
                player.getNationalTeamStats(),
                player.getDetailMatchStats(),
                player.getPersonalDetailNews()
        );
    }

    public static Player mapToPlayer (PlayerDto playerDto) {
        return new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getNationality(),
                playerDto.getBirthPlace(),
                playerDto.getHeight(),
                playerDto.getBirthDate(),
                playerDto.getMarketValue(),
                playerDto.getTeam(),
                playerDto.getTeamId(),
                playerDto.getShirtNumber(),
                playerDto.getPosition(),
                playerDto.getDetailPosition(),
                playerDto.getOtherPosition(),
                playerDto.getGoalQuantity(),
                playerDto.getImageLink(),
                playerDto.getAppearances(),
                playerDto.getCleanSheets(),
                playerDto.getGoalConceded(),
                playerDto.getSaves(),
                playerDto.getAssist(),
                playerDto.getMinutePlayed(),
                playerDto.getNationalityImageLink(),
                playerDto.getFormerInternational(),
                playerDto.getPreferredFoot(),
                playerDto.getContracts(),
                playerDto.getStats(),
                playerDto.getPlayerRatings(),
                playerDto.getPriorityPositions(),
                playerDto.getTransfers(),
                playerDto.getYouthClubs(),
                playerDto.getPersonalMarketValues(),
                playerDto.getRumours(),
                playerDto.getNationalTeamStats(),
                playerDto.getDetailMatchStats(),
                playerDto.getPersonalDetailNews()
        );
    }
}
