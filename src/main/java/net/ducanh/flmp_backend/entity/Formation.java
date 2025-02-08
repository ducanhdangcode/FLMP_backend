package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerFormation;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formations")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "formationName")
    private String formationName;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "detailSquad")
    @ElementCollection
    private List<PlayerFormation> detailSquad;

    @Column(name = "coachFormation")
    private String coachFormation;

    @Column(name = "formationDescription", length = 10000000)
    private String formationDescription;

    @Column(name = "substitutions")
    @ElementCollection
    private List<PlayerFormation> substitutions;
}
