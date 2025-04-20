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
public class DetailCoachDebutCareer {
    private String leagueType;
    private String competitionName;
    private String clubLogoLink;
    private String debutDate;
    private String opponentLogoLink;
    private String score;
    private String ageAtDebut;
}
