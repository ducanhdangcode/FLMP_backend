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
public class DetailCoachStat {
    private String leagueType;
    private String competitionName;
    private String clubName;
    private int matchCount;
    private int win;
    private int draw;
    private int lose;
    private String achievedRound;
    private String placement;
    private double ppm;
}
