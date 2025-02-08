package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.dto.FormationDto;
import net.ducanh.flmp_backend.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByTeamName (String teamName);
}
