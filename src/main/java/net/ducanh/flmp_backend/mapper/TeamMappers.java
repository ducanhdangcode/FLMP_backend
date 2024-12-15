package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;

public class TeamMappers {
    public static TeamDto mapToTeamDto (Team team) {
        return new TeamDto(
                team.getId(),
                team.getLogo(),
                team.getName(),
                team.getColor(),
                team.getTrophies(),
                team.getStadium(),
                team.getStadiumTotalSeat(),
                team.getStadiumLocation(),
                team.getStadiumOpenDate(),
                team.getStadiumCost(),
                team.getKitColors(),
                team.getChairmanName(),
                team.getChairmanDescription(),
                team.getVideoLinks(),
                team.getFavoriteState(),
                team.getTotalMarketValue(),
                team.getDetailMarketValue(),
                team.getTimeMarketValue()
        );
    }

    public static Team mapToTeam (TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getLogo(),
                teamDto.getName(),
                teamDto.getColor(),
                teamDto.getTrophies(),
                teamDto.getStadium(),
                teamDto.getStadiumTotalSeat(),
                teamDto.getStadiumLocation(),
                teamDto.getStadiumOpenDate(),
                teamDto.getStadiumCost(),
                teamDto.getKitColors(),
                teamDto.getChairmanName(),
                teamDto.getChairmanDescription(),
                teamDto.getVideoLinks(),
                teamDto.getFavoriteState(),
                teamDto.getTotalMarketValue(),
                teamDto.getDetailMarketValue(),
                teamDto.getTimeMarketValue()
        );
    }


}
