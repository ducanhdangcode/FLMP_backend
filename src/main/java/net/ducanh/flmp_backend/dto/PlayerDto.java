package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.*;
import net.ducanh.flmp_backend.entity.CustomEntity.DetailPlayerMarketValue;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private String nationality;
    private String birthPlace;
    private Long height;
    private String birthDate;
    private String marketValue;
    private String team;
    private int teamId;
    private int shirtNumber;
    private String position;
    private String detailPosition;
    private String otherPosition;
    private String goalQuantity;
    private String imageLink;
    private String appearances;
    private String cleanSheets;
    private String goalConceded;
    private String saves;
    private String assist;
    private String minutePlayed;
    private String nationalityImageLink;
    private String formerInternational;
    private String preferredFoot;
    private List<PlayerContract> contracts;
    private List<PlayerStats> stats;
    private List<PlayerDetailRating> playerRatings;
    private List<PlayerPriorityPosition> priorityPositions;
    private List<DetailTransfer> transfers;
    private List<DetailYouthClub> youthClubs;
    private List<DetailPlayerMarketValue> personalMarketValues;
    private List<DetailRumour> rumours;
}
