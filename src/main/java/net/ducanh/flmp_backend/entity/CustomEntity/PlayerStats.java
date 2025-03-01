package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStats {
    private String season;
    private String leagueName;
    private String leagueLogo;
    private String teamName;
    private double appearances;
    private double goals;
    private double assists;
    private double yellowCards;
    private double redCards;
    private double minutePlayed;
    private double saves;
    private double cleanSheets;
}
