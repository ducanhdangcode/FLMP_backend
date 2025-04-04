package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailCoachStat;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoachDto {
    private Long id;
    private String name;
    private String imageLink;
    private String teamName;
    private String nationality;
    private String birthDate;
    private List<String> listTeamManaged;
    private String nationalityImage;
    private String totalMatches;
    private String currentMatches;
    private String pointPerMatch;
    private List<DetailCoachStat> detailStats;
}
