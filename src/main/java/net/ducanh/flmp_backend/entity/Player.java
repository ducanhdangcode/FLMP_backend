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
@Table (name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "birth-place", nullable = false)
    private String birthPlace;

    @Column(name = "height", nullable = false)
    private Long height;

    @Column(name = "birthDate", nullable = false)
    private String birthDate;

    @Column(name = "marketValue", nullable = false)
    private String marketValue;

    @Column(name = "team", nullable = false)
    private String team;

    @Column(name = "team-id")
    private int teamId;

    @Column(name = "shirt_number", nullable = false)
    private int shirtNumber;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "detail-position", nullable = false)
    private String detailPosition;

    @Column(name = "other-position", nullable = false)
    private String otherPosition;

    @Column(name = "goal_quantity", nullable = false)
    private String goalQuantity;

    @Column(name = "image-link", nullable = false, length = 1000000)
    private String imageLink;

    @Column(name = "appearances")
    private String appearances;

    @Column(name = "clean-sheets")
    private String cleanSheets;

    @Column(name = "goals-conceded")
    private String goalConceded;

    @Column(name = "saves")
    private String saves;

    @Column(name = "assists")
    private String assist;

    @Column(name = "minutes-played")
    private String minutePlayed;

    @Column(name = "nationality-image-link", length = 100000)
    private String nationalityImageLink;

    @Column(name = "former-international")
    private String formerInternational;

    @Column(name = "preferred-foot")
    private String preferredFoot;

    @Column(name = "contracts")
    @ElementCollection
    private List<PlayerContract> contracts;

    @Column(name = "statistics")
    @ElementCollection
    private List<PlayerStats> stats;

    @Column(name = "rating")
    @ElementCollection
    private List<PlayerDetailRating> playerRatings;

    @Column(name = "priority-position-list")
    @ElementCollection
    private List<PlayerPriorityPosition> priorityPositions;

    @Column(name = "transfers")
    @ElementCollection
    private List<DetailTransfer> transfers;

    @Column(name = "youth-clubs")
    @ElementCollection
    private List<DetailYouthClub> youthClubs;

    @Column(name = "detail-market-value")
    @ElementCollection
    private List<DetailPlayerMarketValue> personalMarketValues;

    @Column(name = "rumours")
    @ElementCollection
    private List<DetailRumour> rumours;

    @Column(name = "national-team-stats")
    @ElementCollection
    private List<DetailNationalTeamStat> nationalTeamStats;

    @Column(name = "detail-match-stat")
    @ElementCollection
    private List<DetailMatchStats> detailMatchStats;

    @Column(name = "personal-detail-news")
    @ElementCollection
    private List<PersonalDetailNews> personalDetailNews;
}
