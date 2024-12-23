package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.MarketValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketValueRepository extends JpaRepository<MarketValue, Long> {
}
