package net.ducanh.flmp_backend.repository;

import net.ducanh.flmp_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
