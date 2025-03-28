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
public class DetailNationalTeamStat {
    private String leagueName;
    private String leagueLogoLink;
    private int appearances;
    private int goal;
    private int assist;
    private int goalConceded;
    private int cleanSheet;
    private int yellowCard;
    private int redCard;
    private int minutePlayed;
}
