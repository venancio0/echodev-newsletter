package com.gvc.echodev_newsletter.application.service;

import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendNewsLetter(List<Subscriber> subscriberList, String subject, String content){
        for(Subscriber subscriber : subscriberList){
            sendEmail(subscriber.getEmail(), subject, content);
        }
    }

    private void sendEmail(String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
