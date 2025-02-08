package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.FormationDto;
import net.ducanh.flmp_backend.entity.Formation;

public class FormationMappers {
    public static FormationDto mapToFormationDto (Formation formation) {
        return new FormationDto (
                formation.getId(),
                formation.getFormationName(),
                formation.getTeamName(),
                formation.getDetailSquad(),
                formation.getCoachFormation(),
                formation.getFormationDescription(),
                formation.getSubstitutions()
        );
    }

    public static Formation mapToFormation (FormationDto formationDto) {
        return new Formation (
                formationDto.getId(),
                formationDto.getFormationName(),
                formationDto.getTeamName(),
                formationDto.getDetailSquad(),
                formationDto.getCoachFormation(),
                formationDto.getFormationDescription(),
                formationDto.getSubstitutions()
        );
    }
}
