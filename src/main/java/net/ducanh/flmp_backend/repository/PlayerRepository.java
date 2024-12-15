package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
