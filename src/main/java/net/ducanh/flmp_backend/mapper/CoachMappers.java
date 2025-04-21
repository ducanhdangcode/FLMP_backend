package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;

public class CoachMappers {
    public static CoachDto mapToCoachDto (Coach coach) {
        return new CoachDto (
                coach.getId(),
                coach.getName(),
                coach.getImageLink(),
                coach.getTeamName(),
                coach.getNationality(),
                coach.getBirthDate(),
                coach.getBirthPlace(),
                coach.getHeight(),
                coach.getListTeamManaged(),
                coach.getNationalityImage(),
                coach.getCoachingLicense(),
                coach.getAverageTerm(),
                coach.getPreferredFormation(),
                coach.getAgent(),
                coach.getTotalMatches(),
                coach.getCurrentMatches(),
                coach.getPointPerMatch(),
                coach.getDetailStats(),
                coach.getContracts(),
                coach.getHistories(),
                coach.getRecordsAgainstClub(),
                coach.getRecordsAgainstManager(),
                coach.getDebutCareers(),
                coach.getSpecialMatchCareers()
        );
    }

    public static Coach mapToCoach (CoachDto coachDto) {
        return new Coach (
                coachDto.getId(),
                coachDto.getName(),
                coachDto.getImageLink(),
                coachDto.getTeamName(),
                coachDto.getNationality(),
                coachDto.getBirthDate(),
                coachDto.getBirthPlace(),
                coachDto.getHeight(),
                coachDto.getListTeamManaged(),
                coachDto.getNationalityImage(),
                coachDto.getCoachingLicense(),
                coachDto.getAverageTerm(),
                coachDto.getPreferredFormation(),
                coachDto.getAgent(),
                coachDto.getTotalMatches(),
                coachDto.getCurrentMatches(),
                coachDto.getPointPerMatch(),
                coachDto.getDetailStats(),
                coachDto.getContracts(),
                coachDto.getHistories(),
                coachDto.getRecordsAgainstClub(),
                coachDto.getRecordsAgainstManager(),
                coachDto.getDebutCareers(),
                coachDto.getSpecialMatchCareers()
        );
    }
}
