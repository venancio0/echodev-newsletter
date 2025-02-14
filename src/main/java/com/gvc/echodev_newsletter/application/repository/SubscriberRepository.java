package com.gvc.echodev_newsletter.application.repository;

import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    Optional<Subscriber> findByEmail(String email);
}
