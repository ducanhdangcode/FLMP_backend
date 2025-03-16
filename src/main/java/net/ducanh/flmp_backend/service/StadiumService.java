package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.StadiumDto;

import java.util.List;

public interface StadiumService {
    StadiumDto createStadium (StadiumDto stadiumDto);

    List<StadiumDto> getAllStadiums();

    StadiumDto updateStadium(Long stadiumId, StadiumDto stadiumDto);

    StadiumDto getStadiumById (Long stadiumId);

    StadiumDto getStadiumByTeamName (String teamName);
}
