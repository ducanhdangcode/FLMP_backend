package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.TeamMappers;
import net.ducanh.flmp_backend.mapper.UserMappers;
import net.ducanh.flmp_backend.repository.TeamRepository;
import net.ducanh.flmp_backend.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = TeamMappers.mapToTeam(teamDto);
        Team savedTeam = teamRepository.save(team);
        return TeamMappers.mapToTeamDto(savedTeam);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map((team) -> TeamMappers.mapToTeamDto(team)).collect(Collectors.toList());
    }

    @Override
    public TeamDto updateTeam(Long teamId, TeamDto updatedTeam) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new ResourceNotFoundException("Team is not existed with the given id: " + teamId)
        );
        team.setName(updatedTeam.getName());
        team.setLogo(updatedTeam.getLogo());
        team.setColor(updatedTeam.getColor());
        team.setTrophies(updatedTeam.getTrophies());
        team.setStadium(updatedTeam.getStadium());
        team.setStadiumTotalSeat(updatedTeam.getStadiumTotalSeat());
        team.setStadiumLocation(updatedTeam.getStadiumLocation());
        team.setStadiumOpenDate(updatedTeam.getStadiumOpenDate());
        team.setStadiumCost(updatedTeam.getStadiumCost());
        team.setKitColors(updatedTeam.getKitColors());
        team.setChairmanName(updatedTeam.getChairmanName());
        team.setChairmanDescription(updatedTeam.getChairmanDescription());
        team.setVideoLinks(updatedTeam.getVideoLinks());
        team.setFavoriteState(updatedTeam.getFavoriteState());
        team.setTotalMarketValue(updatedTeam.getTotalMarketValue());
        team.setDetailMarketValue(updatedTeam.getDetailMarketValue());
        team.setTimeMarketValue(updatedTeam.getTimeMarketValue());

        Team updatedTeamObj = teamRepository.save(team);
        return TeamMappers.mapToTeamDto(updatedTeamObj);
    }

    @Override
    public TeamDto getTeamById(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new ResourceNotFoundException("Team is not existed with the given id: " + teamId)
        );
        return TeamMappers.mapToTeamDto(team);
    }
}
