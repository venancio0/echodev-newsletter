package com.gvc.echodev_newsletter.application.service;

import com.gvc.echodev_newsletter.domain.entity.Subscriber;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendNewsLetter(List<Subscriber> subscriberList, String subject, String content){
        String formattedContent = formatEmailContent(subject, content);

        for(Subscriber subscriber : subscriberList){
            sendEmail(subscriber.getEmail(), subject, formattedContent);
        }
    }

    private void sendEmail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail", e);
        }
    }

    private String formatEmailContent(String subject, String content) {
        try {
            ClassPathResource resource = new ClassPathResource("templates/email-template.html");

            try (InputStream inputStream = resource.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

                String template = reader.lines().collect(Collectors.joining("\n"));

                // Substitui os placeholders no template
                return template.replace("{{subject}}", subject)
                        .replace("{{content}}", content);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o template do e-mail", e);
        }
    }
}
