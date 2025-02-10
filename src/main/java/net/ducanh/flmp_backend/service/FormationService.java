package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.FormationDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerFormation;
import net.ducanh.flmp_backend.entity.CustomEntity.UpdateSquadFormationRequest;
import net.ducanh.flmp_backend.entity.Formation;
import net.ducanh.flmp_backend.entity.Player;
import org.hibernate.sql.Update;

import java.util.List;

public interface FormationService {
    FormationDto createFormation(FormationDto formationDto);

    List<FormationDto> getAllFormations();

    FormationDto updateFormation(Long formationId, FormationDto formationDto);

    FormationDto getFormationById(Long formationId);

    List<Formation> getFormationByTeamName (String teamName);

    FormationDto updateFormationSquad (Long formationId, UpdateSquadFormationRequest request);
}
