package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupedCoachStatByCompetition {
    private String competitionName;
    private String competitionLogoLink;
    private int totalMatches;
    private int totalWins;
    private int totalDraws;
    private int totalLoses;
}
