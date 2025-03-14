package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.TeamDto;
import net.ducanh.flmp_backend.entity.Team;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.TeamMappers;
import net.ducanh.flmp_backend.mapper.UserMappers;
import net.ducanh.flmp_backend.repository.TeamRepository;
import net.ducanh.flmp_backend.service.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Team> getAllTeams(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Override
    public TeamDto updateTeam(Long teamId, TeamDto updatedTeam) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new ResourceNotFoundException("Team is not existed with the given id: " + teamId)
        );
        team.setName(updatedTeam.getName());
        team.setColor(updatedTeam.getColor());
        team.setTrophies(updatedTeam.getTrophies());
        team.setChairmanName(updatedTeam.getChairmanName());
        team.setChairmanDescription(updatedTeam.getChairmanDescription());
        team.setVideoLinks(updatedTeam.getVideoLinks());
        team.setFavoriteState(updatedTeam.getFavoriteState());
        team.setChairmanImage(updatedTeam.getChairmanImage());
        team.setKitsImage(updatedTeam.getKitsImage());
        team.setVideoTitles(updatedTeam.getVideoTitles());

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

    @Override
    public TeamDto updateFavoriteState(Long teamId, String favoriteState) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new ResourceNotFoundException("Team is not existed with the given id: " + teamId)
        );
        team.setFavoriteState(favoriteState);
        Team savedTeam = teamRepository.save(team);
        return TeamMappers.mapToTeamDto(savedTeam);
    }
}
