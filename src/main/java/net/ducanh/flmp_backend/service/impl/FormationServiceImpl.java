package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.FormationDto;
import net.ducanh.flmp_backend.entity.Formation;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.FormationMappers;
import net.ducanh.flmp_backend.repository.FormationRepository;
import net.ducanh.flmp_backend.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {
    private FormationRepository formationRepository;

    @Override
    public FormationDto createFormation(FormationDto formationDto) {
        Formation formation = FormationMappers.mapToFormation(formationDto);
        Formation savedFormation = formationRepository.save(formation);
        return FormationMappers.mapToFormationDto(savedFormation);
    }

    @Override
    public List<FormationDto> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return formations.stream().map((formation) -> FormationMappers.mapToFormationDto(formation)).collect(Collectors.toList());
    }

    @Override
    public FormationDto updateFormation(Long formationId, FormationDto formationDto) {
        Formation formation = formationRepository.findById(formationId).orElseThrow(
                () -> new ResourceNotFoundException("Formation is not found!")
        );
        formation.setFormationName(formationDto.getFormationName());
        formation.setTeamName(formationDto.getTeamName());
        formation.setDetailSquad(formationDto.getDetailSquad());
        formation.setCoachFormation(formationDto.getCoachFormation());
        formation.setFormationDescription(formationDto.getFormationDescription());
        formation.setSubstitutions(formationDto.getSubstitutions());

        Formation savedFormation = formationRepository.save(formation);
        return FormationMappers.mapToFormationDto(savedFormation);
    }

    @Override
    public FormationDto getFormationById(Long formationId) {
        Formation formation = formationRepository.findById(formationId).orElseThrow(
                () -> new ResourceNotFoundException("Formation is not found!")
        );
        return FormationMappers.mapToFormationDto(formation);
    }

    @Override
    public List<Formation> getFormationByTeamName(String teamName) {
        return formationRepository.findByTeamName(teamName);
    }
}
