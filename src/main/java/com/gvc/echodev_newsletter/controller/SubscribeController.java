package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.repository.SubscriberRepository;
import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscriberRepository subscriberRepository;

    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    @GetMapping
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }
}
