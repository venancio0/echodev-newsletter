package com.gvc.echodev_newsletter.application.repository;

import com.gvc.echodev_newsletter.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
