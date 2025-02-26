package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.repository.SubscriberRepository;
import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @Operation(summary = "Find a subscriber by email")
    @ApiResponse(responseCode = "200", description = "Subscriber found")
    @ApiResponse(responseCode = "404", description = "Subscriber not found")
    @GetMapping("/email/{email}")
    public ResponseEntity<Subscriber> getSubscriberByEmail(@PathVariable String email) {
        return subscriberRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Delete a subscriber by ID")
    @ApiResponse(responseCode = "200", description = "Subscriber successfully deleted")
    @ApiResponse(responseCode = "404", description = "Subscriber not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubscriberById(@PathVariable Long id) {
        return subscriberRepository.findById(id)
                .map(subscriber -> {
                    subscriberRepository.delete(subscriber);
                    return ResponseEntity.ok("Subscriber successfully deleted");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subscriber not found"));
    }


}
