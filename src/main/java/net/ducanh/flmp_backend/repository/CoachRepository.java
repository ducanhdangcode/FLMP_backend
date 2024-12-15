package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
