package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image-link", length = 1000000)
    private String imageLink;

    @Column(name = "current-team")
    private String teamName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "birthdate")
    private String birthDate;

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "height")
    private String height;

    @Column(name = "list-team-managed")
    private List<String> listTeamManaged;

    @Column(name = "nationality-image", length = 100000)
    private String nationalityImage;

    @Column(name = "coaching-license")
    private String coachingLicense;

    @Column(name = "average-term")
    private String averageTerm;

    @Column(name = "preferred-formation")
    private String preferredFormation;

    @Column(name = "agent")
    private String agent;

    @Column(name = "total-matches")
    private String totalMatches;

    @Column(name = "current-matches")
    private String currentMatches;

    @Column(name = "point-per-match")
    private String pointPerMatch;

    @Column(name = "detail-stats")
    @ElementCollection
    private List<DetailCoachStat> detailStats;

    @Column(name = "contracts")
    @ElementCollection
    private List<DetailCoachContract> contracts;

    @Column(name = "history")
    @ElementCollection
    private List<DetailCoachHistory> histories;

    @Column(name = "records-against-club")
    @ElementCollection
    private List<DetailCoachRecordAgainstClub> recordsAgainstClub;

    @Column(name = "records-against-manager")
    @ElementCollection
    private List<DetailCoachRecordAgainstManager> recordsAgainstManager;

    @Column(name = "debut-careers")
    @ElementCollection
    private List<DetailCoachDebutCareer> debutCareers;
}
