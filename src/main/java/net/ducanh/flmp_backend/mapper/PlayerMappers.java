package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.PlayerDto;
import net.ducanh.flmp_backend.entity.Player;

public class PlayerMappers {
    public static PlayerDto mapToPlayerDto (Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getNationality(),
                player.getHeight(),
                player.getWeight(),
                player.getBirthDate(),
                player.getMarketValue(),
                player.getTeam(),
                player.getTeamId(),
                player.getShirtNumber(),
                player.getPosition(),
                player.getGoalQuantity(),
                player.getImageLink(),
                player.getAppearances(),
                player.getCleanSheets(),
                player.getGoalConceded(),
                player.getSaves(),
                player.getAssist(),
                player.getMinutePlayed(),
                player.getNationalityImageLink()
        );
    }

    public static Player mapToPlayer (PlayerDto playerDto) {
        return new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getNationality(),
                playerDto.getHeight(),
                playerDto.getWeight(),
                playerDto.getBirthDate(),
                playerDto.getMarketValue(),
                playerDto.getTeam(),
                playerDto.getTeamId(),
                playerDto.getShirtNumber(),
                playerDto.getPosition(),
                playerDto.getGoalQuantity(),
                playerDto.getImageLink(),
                playerDto.getAppearances(),
                playerDto.getCleanSheets(),
                playerDto.getGoalConceded(),
                playerDto.getSaves(),
                playerDto.getAssist(),
                playerDto.getMinutePlayed(),
                playerDto.getNationalityImageLink()
        );
    }
}
