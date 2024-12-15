package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.CoachDto;
import net.ducanh.flmp_backend.entity.Coach;

public class CoachMappers {
    public static CoachDto mapToCoachDto (Coach coach) {
        return new CoachDto (
                coach.getId(),
                coach.getName(),
                coach.getImageLink(),
                coach.getNationality(),
                coach.getBirthDate(),
                coach.getListTeamManaged(),
                coach.getNationalityImage(),
                coach.getTotalMatches(),
                coach.getCurrentMatches(),
                coach.getPointPerMatch()
        );
    }

    public static Coach mapToCoach (CoachDto coachDto) {
        return new Coach (
                coachDto.getId(),
                coachDto.getName(),
                coachDto.getImageLink(),
                coachDto.getNationality(),
                coachDto.getBirthDate(),
                coachDto.getListTeamManaged(),
                coachDto.getNationalityImage(),
                coachDto.getTotalMatches(),
                coachDto.getCurrentMatches(),
                coachDto.getPointPerMatch()
        );
    }
}
