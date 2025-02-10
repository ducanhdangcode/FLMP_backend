package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.FormationDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerFormation;
import net.ducanh.flmp_backend.entity.CustomEntity.UpdateSquadFormationRequest;
import net.ducanh.flmp_backend.entity.Formation;
import net.ducanh.flmp_backend.entity.Player;
import net.ducanh.flmp_backend.service.FormationService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/formations")
public class FormationController {
    private FormationService formationService;

    @PostMapping
    public ResponseEntity<FormationDto> createFormation(@RequestBody FormationDto formationDto) {
        FormationDto savedFormation = formationService.createFormation(formationDto);
        return new ResponseEntity<>(savedFormation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormationDto>> getAllFormations () {
        List<FormationDto> formations = formationService.getAllFormations();
        return ResponseEntity.ok(formations);
    }

    @GetMapping("{id}")
    public ResponseEntity<FormationDto> getFormationById (@PathVariable("id") Long formationId) {
        FormationDto formationDto = formationService.getFormationById(formationId);
        return ResponseEntity.ok(formationDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<FormationDto> updateFormation (@PathVariable("id") Long formationId, @RequestBody FormationDto formationDto) {
        FormationDto updatedFormationDto = formationService.updateFormation(formationId, formationDto);
        return ResponseEntity.ok(updatedFormationDto);
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<Formation>> getFormationByTeamName(@PathVariable String teamName) {
        List<Formation> formations = formationService.getFormationByTeamName(teamName);
        return ResponseEntity.ok(formations);
    }

    @PutMapping("/{id}/update-squad")
    public ResponseEntity<FormationDto> updateFormationSquad (@PathVariable Long id,
                                                              @RequestBody UpdateSquadFormationRequest request) {
        FormationDto formationDto = formationService.updateFormationSquad(id, request);
        return ResponseEntity.ok(formationDto);
    }
}
