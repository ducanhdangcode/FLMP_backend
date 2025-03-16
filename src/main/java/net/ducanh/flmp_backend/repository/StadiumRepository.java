package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    Optional<Stadium> findByTeamName (String teamName);
}
