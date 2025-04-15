package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;
import net.ducanh.flmp_backend.entity.CustomEntity.*;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.CoachMappers;
import net.ducanh.flmp_backend.repository.CoachRepository;
import net.ducanh.flmp_backend.service.ICoachService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<GroupedCoachStatByCompetition> getGroupedCoachStatByCompetition(String coachName, String leagueType) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachStat> detailCoachStats =
                coach.getDetailStats().stream().filter(stat -> stat.getLeagueType().equals(leagueType)).collect(Collectors.toList());
        Map<String, GroupedCoachStatByCompetition> groupedStats =
                detailCoachStats.stream().collect(Collectors.groupingBy(DetailCoachStat::getCompetitionName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            int totalMatches = list.stream().mapToInt(DetailCoachStat::getMatchCount).sum();
                            int totalWins = list.stream().mapToInt(DetailCoachStat::getWin).sum();
                            int totalDraws = list.stream().mapToInt(DetailCoachStat::getDraw).sum();
                            int totalLoses = list.stream().mapToInt(DetailCoachStat::getLose).sum();

                            return new GroupedCoachStatByCompetition(
                                    list.get(0).getCompetitionName(),
                                    list.get(0).getCompetitionLogoLink(),
                                    totalMatches,
                                    totalWins,
                                    totalDraws,
                                    totalLoses
                            );
                        })));
        return new ArrayList<>(groupedStats.values());
    }

    @Override
    public CoachDto addCoachStats(String coachName, DetailCoachStat stat) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachStat> detailCoachStats = coach.getDetailStats();
        detailCoachStats.add(stat);
        coach.setDetailStats(new ArrayList<>(detailCoachStats));
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public List<DetailCoachStat> getCoachStatsByCompetitionName(String coachName, String competitionName) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachStat> detailCoachStats = coach.getDetailStats();
        return detailCoachStats.stream().filter(stat -> stat.getCompetitionName().equals(competitionName)).collect(Collectors.toList());
    }

    @Override
    public CoachDto updateDetailCoachStats(String coachName, List<DetailCoachStat> stats) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        coach.setDetailStats(stats);
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public List<DetailCoachStat> getCoachStatsByLeagueType(String coachName, String leagueType) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        return coach.getDetailStats().stream().filter(stat -> stat.getLeagueType().equals(leagueType)).collect(Collectors.toList());
    }

    @Override
    public CoachDto addCoachHistory(String coachName, DetailCoachHistory history) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachHistory> histories = coach.getHistories();
        histories.add(history);
        coach.setHistories(new ArrayList<>(histories));
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public CoachDto addCoachRecordAgainstClub(String coachName, DetailCoachRecordAgainstClub record) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachRecordAgainstClub> records = coach.getRecordsAgainstClub();
        records.add(record);
        coach.setRecordsAgainstClub(new ArrayList<>(records));
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }

    @Override
    public CoachDto addCoachRecordAgainstManager(String coachName, DetailCoachRecordAgainstManager record) {
        Coach coach = coachRepository.findByName(coachName).orElseThrow(
                () -> new ResourceNotFoundException("Coach is not existed with the given name: " + coachName)
        );
        List<DetailCoachRecordAgainstManager> records = coach.getRecordsAgainstManager();
        records.add(record);
        coach.setRecordsAgainstManager(new ArrayList<>(records));
        Coach savedCoach = coachRepository.save(coach);
        return CoachMappers.mapToCoachDto(savedCoach);
    }
}
