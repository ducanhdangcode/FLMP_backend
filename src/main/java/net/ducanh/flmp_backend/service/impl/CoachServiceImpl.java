package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.CoachMappers;
import net.ducanh.flmp_backend.repository.CoachRepository;
import net.ducanh.flmp_backend.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CoachServiceImpl implements CoachService {
    private CoachRepository coachRepository;
    @Override
    public CoachDto createCoach(CoachDto coachDto) {
        Coach coach = CoachMappers.mapToCoach(coachDto);
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public List<CoachDto> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream().map((coach) -> CoachMappers.mapToCoachDto(coach)).collect(Collectors.toList());
    }

    @Override
    public CoachDto updateCoach(Long coachId, CoachDto coachDto) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given id: " + coachId)
        );
        coach.setName(coachDto.getName());
        coach.setImageLink(coachDto.getImageLink());
        coach.setBirthDate(coachDto.getBirthDate());
        coach.setNationality(coachDto.getNationality());
        coach.setImageLink(coachDto.getImageLink());
        coach.setNationalityImage(coachDto.getNationalityImage());
        coach.setTotalMatches(coachDto.getTotalMatches());
        coach.setCurrentMatches(coachDto.getCurrentMatches());
        coach.setPointPerMatch(coachDto.getPointPerMatch());

        Coach updatedCoachObj = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(updatedCoachObj);
    }

    @Override
    public CoachDto getCoachById(Long coachId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given id: " + coachId)
        );
        return CoachMappers.mapToCoachDto(coach);
    }
}
