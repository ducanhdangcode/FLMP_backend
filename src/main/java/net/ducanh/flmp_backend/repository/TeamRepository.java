package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
