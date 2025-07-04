package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByName(String playerName);
}
