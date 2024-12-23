package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StadiumDto {
    private Long id;
    private String name;
    private String totalSeat;
    private String location;
    private String openDate;
    private String constructionCost;
}
