package net.ducanh.flmp_backend.entity.CustomEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSquadFormationRequest {
    private List<PlayerFormation> mainSquad;
    private List<PlayerFormation> substitutions;
}
