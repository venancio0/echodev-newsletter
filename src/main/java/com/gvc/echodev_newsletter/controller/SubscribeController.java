package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.repository.SubscriberRepository;
import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscriberRepository subscriberRepository;

    @Operation(summary = "Sign up a new subscriber to the newsletter")
    @ApiResponse(responseCode = "201", description = "Subscriber sucessfully registered!")
    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber){
        subscriber.setSubscribedAt(LocalDateTime.now());
        return subscriberRepository.save(subscriber);
    }

    @Operation(summary = "List all current subscribers", description = "Return a list with all current subscribers to the newsletter")
    @ApiResponse(responseCode = "200", description = "List sucessfully returned!")
    @GetMapping
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }
}
