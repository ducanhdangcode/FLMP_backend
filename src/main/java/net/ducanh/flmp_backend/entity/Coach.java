package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
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

    @Column(name = "list-team-managed")
    private List<String> listTeamManaged;

    @Column(name = "nationality-image", length = 100000)
    private String nationalityImage;

    @Column(name = "total-matches")
    private String totalMatches;

    @Column(name = "current-matches")
    private String currentMatches;

    @Column(name = "point-per-match")
    private String pointPerMatch;

    @Column(name = "detail-stats")
    @ElementCollection
    private List<DetailCoachStat> detailStats;
}
