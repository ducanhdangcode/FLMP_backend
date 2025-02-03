package net.ducanh.flmp_backend.service.impl;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.StadiumDto;
import net.ducanh.flmp_backend.entity.Stadium;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.StadiumMappers;
import net.ducanh.flmp_backend.repository.StadiumRepository;
import net.ducanh.flmp_backend.service.StadiumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StadiumServiceImpl implements StadiumService {
    private StadiumRepository stadiumRepository;
    @Override
    public StadiumDto createStadium(StadiumDto stadiumDto) {
        Stadium stadium = StadiumMappers.mapToStadium(stadiumDto);
        Stadium savedStadium = stadiumRepository.save(stadium);
        return StadiumMappers.mapToStadiumDto(savedStadium);
    }

    @Override
    public List<StadiumDto> getAllStadiums() {
        List<Stadium> stadiums = stadiumRepository.findAll();
        return stadiums.stream().map((stadium) -> StadiumMappers.mapToStadiumDto(stadium)).collect(Collectors.toList());
    }

    @Override
    public StadiumDto updateStadium(Long stadiumId, StadiumDto stadiumDto) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(
                () -> new ResourceNotFoundException("Stadium is not existed with the given id: " + stadiumId)
        );
        stadium.setName(stadiumDto.getName());
        stadium.setTotalSeat(stadiumDto.getTotalSeat());
        stadium.setLocation(stadiumDto.getLocation());
        stadium.setOpenDate(stadiumDto.getOpenDate());
        stadium.setConstructionCost(stadiumDto.getConstructionCost());
        stadium.setImageLink(stadiumDto.getImageLink());

        Stadium updatedStadiumObj = stadiumRepository.save(stadium);
        return StadiumMappers.mapToStadiumDto(updatedStadiumObj);
    }

    @Override
    public StadiumDto getStadiumById(Long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(
                () -> new ResourceNotFoundException("Stadium is not existed with the given id: " + stadiumId)
        );
        return StadiumMappers.mapToStadiumDto(stadium);
    }
}
