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
public class DetailMatchStats {
    private String competitionName;
    private String competitionLink;
    private String matchDay;
    private String date;
    private String venue;
    private String teamPlayForLink;
    private String opponentName;
    private String opponentLink;
    private String result;
    private String detailScore;
    private String position;
    private int goals;
    private int assists;
    private int cleanSheets;
    private int goalConceded;
    private int yellowCardMinute;
    private int redCardMinute;
    private int minutePlayed;
    private String status;
}
