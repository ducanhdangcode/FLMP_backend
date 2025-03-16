package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.StadiumDto;
import net.ducanh.flmp_backend.entity.Stadium;

public class StadiumMappers {
    public static StadiumDto mapToStadiumDto (Stadium stadium) {
        return new StadiumDto (
                stadium.getId(),
                stadium.getName(),
                stadium.getTeamName(),
                stadium.getTotalSeat(),
                stadium.getLocation(),
                stadium.getOpenDate(),
                stadium.getConstructionCost(),
                stadium.getImageLink()
        );
    }

    public static Stadium mapToStadium (StadiumDto stadiumDto) {
        return new Stadium (
                stadiumDto.getId(),
                stadiumDto.getName(),
                stadiumDto.getTeamName(),
                stadiumDto.getTotalSeat(),
                stadiumDto.getLocation(),
                stadiumDto.getOpenDate(),
                stadiumDto.getConstructionCost(),
                stadiumDto.getImageLink()
        );
    }
}
