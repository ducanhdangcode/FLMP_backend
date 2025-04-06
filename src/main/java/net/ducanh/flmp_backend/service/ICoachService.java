package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachContract;

import java.util.List;

public interface ICoachService {
    CoachDto createCoach(CoachDto coachDto);

    List<CoachDto> getAllCoaches();

    CoachDto updateCoach(Long coachId, CoachDto coachDto);

    CoachDto getCoachById(Long coachId);

    CoachDto getCoachByTeamName(String currentTeamName);

    CoachDto getCoachByCoachName(String coachName);

    CoachDto addCoachContract(String coachName, DetailCoachContract contract);

    DetailCoachContract getContractByTeamName(String coachName, String teamName);
}
