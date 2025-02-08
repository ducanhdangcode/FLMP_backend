package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerFormation;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormationDto {
    private Long id;
    private String formationName;
    private String teamName;
    private List<PlayerFormation> detailSquad;
    private String coachFormation;
    private String formationDescription;
    private List<PlayerFormation> substitutions;
}
