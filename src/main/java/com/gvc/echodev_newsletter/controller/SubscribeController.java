package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.repository.SubscriberRepository;
import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscriberRepository subscriberRepository;

    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber){
        subscriber.setSubscribedAt(LocalDateTime.now());
        return subscriberRepository.save(subscriber);
    }

    @GetMapping
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }
}
