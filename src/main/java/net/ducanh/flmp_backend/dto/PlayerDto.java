package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private String nationality;
    private Long height;
    private Long weight;
    private String birthDate;
    private String marketValue;
    private String team;
    private int teamId;
    private int shirtNumber;
    private String position;
    private String goalQuantity;
    private String imageLink;
    private String appearances;
    private String cleanSheets;
    private String goalConceded;
    private String saves;
    private String assist;
    private String minutePlayed;
    private String nationalityImageLink;
}
