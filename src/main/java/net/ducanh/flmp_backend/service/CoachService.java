package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.CoachDto;

import java.util.List;

public interface CoachService {
    CoachDto createCoach(CoachDto coachDto);

    List<CoachDto> getAllCoaches();

    CoachDto updateCoach(Long coachId, CoachDto coachDto);

    CoachDto getCoachById (Long coachId);
}
