package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.*;

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
    private String birthPlace;
    private String height;
    private List<String> listTeamManaged;
    private String nationalityImage;
    private String coachingLicense;
    private String averageTerm;
    private String preferredFormation;
    private String agent;
    private String totalMatches;
    private String currentMatches;
    private String pointPerMatch;
    private List<DetailCoachStat> detailStats;
    private List<DetailCoachContract> contracts;
    private List<DetailCoachHistory> histories;
    private List<DetailCoachRecordAgainstClub> recordsAgainstClub;
    private List<DetailCoachRecordAgainstManager> recordsAgainstManager;
}
