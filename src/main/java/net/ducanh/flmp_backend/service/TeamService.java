package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto createTeam (TeamDto teamDto);

    List<TeamDto> getAllTeams();

    TeamDto updateTeam(Long teamId, TeamDto updatedTeam);

    TeamDto getTeamById (Long employeeId);
}
