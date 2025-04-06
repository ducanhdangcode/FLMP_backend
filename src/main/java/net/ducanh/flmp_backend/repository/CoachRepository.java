package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByTeamName(String teamName);

    Optional<Coach> findByName (String coachName);
}
