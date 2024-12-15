package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "height", nullable = false)
    private Long height;

    @Column(name = "weight", nullable = false)
    private Long weight;

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
}
