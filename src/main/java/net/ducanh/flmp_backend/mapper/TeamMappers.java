package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;

public class TeamMappers {
    public static TeamDto mapToTeamDto (Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getColor(),
                team.getTrophies(),
                team.getChairmanName(),
                team.getChairmanDescription(),
                team.getVideoLinks(),
                team.getFavoriteState(),
                team.getChairmanImage(),
                team.getKitsImage()
        );
    }

    public static Team mapToTeam (TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getName(),
                teamDto.getColor(),
                teamDto.getTrophies(),
                teamDto.getChairmanName(),
                teamDto.getChairmanDescription(),
                teamDto.getVideoLinks(),
                teamDto.getFavoriteState(),
                teamDto.getChairmanImage(),
                teamDto.getKitsImage()
        );
    }


}
