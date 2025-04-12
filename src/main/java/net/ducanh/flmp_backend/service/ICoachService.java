package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachContract;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachHistory;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachStat;
import net.ducanh.flmp_backend.entity.CustomEntity.GroupedCoachStatByCompetition;

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

    List<GroupedCoachStatByCompetition> getGroupedCoachStatByCompetition(String coachName, String leagueType);

    CoachDto addCoachStats(String coachName, DetailCoachStat stat);

    List<DetailCoachStat> getCoachStatsByCompetitionName (String coachName, String competitionName);

    CoachDto updateDetailCoachStats (String coachName, List<DetailCoachStat> stats);

    List<DetailCoachStat> getCoachStatsByLeagueType (String coachName, String leagueType);

    CoachDto addCoachHistory (String coachName, DetailCoachHistory history);
}
