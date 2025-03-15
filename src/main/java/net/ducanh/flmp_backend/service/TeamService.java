package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamService {
    TeamDto createTeam (TeamDto teamDto);

    Page<Team> getAllTeams (Pageable pageable);

    TeamDto updateTeam(Long teamId, TeamDto updatedTeam);

    TeamDto getTeamById (Long employeeId);

    TeamDto updateFavoriteState (Long teamId, String favoriteState);

    TeamDto getTeamByTeamName (String teamName);

    String deleteTeamById (Long teamId);
}
