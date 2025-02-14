package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.dto.NewsletterRequestDTO;
import com.gvc.echodev_newsletter.application.repository.SubscriberRepository;
import com.gvc.echodev_newsletter.application.service.EmailService;
import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/newsletters")
@RequiredArgsConstructor
public class NewsletterController {
    private final EmailService emailService;
    private final SubscriberRepository subscriberRepository;

    @PostMapping("/send")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sendNewsletter(@RequestBody NewsletterRequestDTO newsletterRequest){
        List<Subscriber> subscriberList = subscriberRepository.findAll();

        if(subscriberList.isEmpty()){
            return ResponseEntity.badRequest().body("Nenhum inscrito encontrado.");
        }

        emailService.sendNewsLetter(subscriberList, newsletterRequest.getSubject(), newsletterRequest.getContent());
        return ResponseEntity.ok("Newsletter enviada com sucesso!");
    }
}
