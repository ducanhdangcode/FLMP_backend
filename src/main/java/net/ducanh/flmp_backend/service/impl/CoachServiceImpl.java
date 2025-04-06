package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachContract;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachStat;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.CoachMappers;
import net.ducanh.flmp_backend.repository.CoachRepository;
import net.ducanh.flmp_backend.service.ICoachService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CoachServiceImpl implements ICoachService {
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
        coach.setTeamName(coachDto.getTeamName());
        coach.setBirthDate(coachDto.getBirthDate());
        coach.setNationality(coachDto.getNationality());
        coach.setImageLink(coachDto.getImageLink());
        coach.setNationalityImage(coachDto.getNationalityImage());
        coach.setTotalMatches(coachDto.getTotalMatches());
        coach.setCurrentMatches(coachDto.getCurrentMatches());
        coach.setPointPerMatch(coachDto.getPointPerMatch());
        coach.setBirthPlace(coachDto.getBirthPlace());
        coach.setHeight(coachDto.getHeight());
        coach.setCoachingLicense(coachDto.getCoachingLicense());
        coach.setAverageTerm(coachDto.getAverageTerm());
        coach.setPreferredFormation(coachDto.getPreferredFormation());
        coach.setAgent(coachDto.getAgent());

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

    @Override
    public CoachDto getCoachByTeamName(String teamName) {
        Coach coach = coachRepository.findByTeamName(teamName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given team name: " + teamName)
        );
        return CoachMappers.mapToCoachDto(coach);
    }

    @Override
    public CoachDto getCoachByCoachName(String coachName) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        return CoachMappers.mapToCoachDto(coach);
    }

    @Override
    public CoachDto addCoachContract(String coachName, DetailCoachContract contract) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachContract> contracts = coach.getContracts();
        contracts.add(contract);
        coach.setContracts(new ArrayList<>(contracts));
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public DetailCoachContract getContractByTeamName(String coachName, String teamName) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachContract> contracts = coach.getContracts();
        return contracts.stream().filter(contract -> contract.getTeamName().equals(teamName)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Contract is not existed")
        );
    }
}
